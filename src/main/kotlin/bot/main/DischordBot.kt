package bot.main

import bot.permissions.BotPermissions
import dev.kord.common.annotation.KordPreview
import dev.kord.gateway.Intents
import kotlinx.coroutines.flow.toList
import me.jakejmattson.discordkt.dsl.CommandException
import me.jakejmattson.discordkt.dsl.ListenerException
import me.jakejmattson.discordkt.dsl.bot
import me.jakejmattson.discordkt.locale.Language
import java.awt.Color
import javax.inject.Inject
import javax.inject.Named


class DischordBot @Inject constructor(
    @Named("BotToken") private val botToken: String,
) {

    @OptIn(KordPreview::class)
    suspend fun startBot() {
        bot(botToken) {
            prefix {
                "?"
            }

            //Simple configuration options
            configure {
                //Allow a mention to be used in front of commands ('@Bot help').
                mentionAsPrefix = true

                //Whether to show registered entity information on startup.
                logStartup = true

                //Whether to generate documentation for registered commands.
                documentCommands = false

                //Whether to recommend commands when an invalid one is invoked.
                recommendCommands = true

                //Allow users to search for a command by typing 'search <command name>'.
                searchCommands = true

                //Remove a command invocation message after the command is executed.
                deleteInvocation = true

                //Allow slash commands to be invoked as text commands.
                dualRegistry = true

                //An emoji added when a command is invoked (use 'null' to disable this).
                commandReaction = null

                //A color constant for your bot - typically used in embeds.
                theme = Color(0x00BFFF)

                //Configure the Discord Gateway intents for your bot.
                intents = Intents.none

                //Set the default permission required for slash commands.
                defaultPermissions = BotPermissions.EVERYONE
            }


            onException {
                if (exception is IllegalArgumentException)
                    return@onException

                when (this) {
                    is CommandException -> println("Exception '${exception::class.simpleName}' in command ${event.command?.name}")
                    is ListenerException -> println("Exception '${exception::class.simpleName}' in listener ${event::class.simpleName}")
                }
            }

            //The Discord presence shown on your bot.
            presence {
                playing("With my Chode")
            }

            //This is run once the bot has finished setup and logged in.
            onStart {
                val guilds = kord.guilds.toList()
                println("Guilds: ${guilds.joinToString { it.name }}")
            }

            //Configure the locale for this bot.
            localeOf(Language.EN) {
                helpName = "Help"
                helpCategory = "Utility"
                commandRecommendation = "Recommendation: {0}"
            }
        }

    }

}