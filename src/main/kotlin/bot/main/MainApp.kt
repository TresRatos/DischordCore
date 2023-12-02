package bot.main

import com.dischord.dagger.DaggerDischordComponent
import dev.kord.common.entity.Snowflake
import dev.kord.core.event.interaction.ChatInputCommandInteractionCreateEvent
import dev.kord.core.on

suspend fun main() {
    val dischord = DaggerDischordComponent.create()

    val kord = dischord.kordClientProvider().getKordClient()
    val commandCategories = dischord.commands()

    val existingGlobalCommands = kord.getGlobalApplicationCommands()
    val existingGuildCommands = kord.getGuildApplicationCommands(
        // We used someone else's fork of Kord for a while. Their fork automatically setup
        // commands for our guild. I am leaving this code here for now to clean up these old commands
        Snowflake(1180173888039178290)
    )
    // TODO We should find a better way to only update commands when we need to
    existingGlobalCommands.collect {
        println("Deleting Command: ${it.name}")
        it.delete()
    }
    existingGuildCommands.collect {
        println("Deleting Command: ${it.name}")
        it.delete()
    }
    commandCategories.forEach { it.register() }
    val commandsByName = commandCategories
        .associateBy { it.name }

    kord.on<ChatInputCommandInteractionCreateEvent> {
        commandsByName[interaction.invokedCommandName]!!.handleInteraction(this)
    }

    kord.login()
}