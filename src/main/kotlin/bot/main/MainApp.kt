package bot.main

import com.dischord.dagger.DaggerDischordComponent

const val START_BOT = "run"
const val REGISTER_COMMANDS = "register"
suspend fun main(args: Array<String>) {
    val runmode: String = args.getOrElse(0) { START_BOT }
    val kord = DaggerDischordComponent.create().getBot()

    when(runmode) {
        REGISTER_COMMANDS -> { kord.registerCommands() }
        START_BOT -> { kord.startBot() }
        else -> { throw RuntimeException("Unexpected runmode specified from command line: $runmode") }
    }
}