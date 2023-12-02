package com.dischord.provider

import dev.kord.core.Kord
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class KordClientProvider @Inject constructor(
    private val tokenProvider: BotTokenProvider
) {
    lateinit var kord: Kord

    fun getKordClient(): Kord {

        if(!::kord.isInitialized) {
            runBlocking { kord = Kord(tokenProvider.getDiscordBotToken()) }
        }
        return kord
    }
}