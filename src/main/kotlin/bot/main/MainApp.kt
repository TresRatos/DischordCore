package bot.main

import com.dischord.dagger.DaggerDischordComponent

suspend fun main() {
    val bot = DaggerDischordComponent.create()

    bot.dischord().startBot()
}