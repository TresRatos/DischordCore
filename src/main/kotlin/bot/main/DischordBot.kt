package bot.main

import com.dischord.commands.Command
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.event.interaction.ChatInputCommandInteractionCreateEvent
import dev.kord.core.on
import javax.inject.Inject

class DischordBot @Inject constructor(
    private val commands: Set<Command>,
    private val client: Kord
) {
    suspend fun registerCommands() {
        val existingGlobalCommands = client.getGlobalApplicationCommands()
        val existingGuildCommands = client.getGuildApplicationCommands(
            // We used someone else's fork of Kord for a while. Their fork automatically setup
            // commands for our guild. I am leaving this code here for now to clean up these old commands
            Snowflake(1180173888039178290)
        )
        existingGlobalCommands.collect {
            println("Deleting Command: ${it.name}")
            it.delete()
        }
        existingGuildCommands.collect {
            println("Deleting Command: ${it.name}")
            it.delete()
        }
        commands.forEach { registerCommand(it) }
    }

    suspend fun startBot() {
        val commandsByName = commands.associateBy { it.name }

        client.on<ChatInputCommandInteractionCreateEvent> {
            commandsByName[interaction.invokedCommandName]!!.handleInteraction(this)
        }

        client.login()
    }

    private suspend fun registerCommand(command: Command) {
        val name = command.name
        val description = command.description

        println("Registering Command $name, with description: $description")
        client.createGlobalChatInputCommand(
            // Discord throws an error if the command name is now all lowercase
            name = name,
            description = description,
        ) {}
        println("Registered Command $name, with description: $description")
    }
}