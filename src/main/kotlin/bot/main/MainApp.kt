package bot.main

import com.dischord.dagger.DaggerDischordComponent

suspend fun main() {
    val dischord = DaggerDischordComponent.create()

    val kord = dischord.kordClient()

    kord.login()
}