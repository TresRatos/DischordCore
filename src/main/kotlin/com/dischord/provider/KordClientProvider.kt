package com.dischord.provider

import dev.kord.core.Kord
import javax.inject.Inject

class KordClientProvider @Inject constructor(
    private val tokenProvider: BotTokenProvider
) {
    lateinit var kord: Kord

    suspend fun getKordClient(): Kord {
        if(!::kord.isInitialized) {
            kord = Kord(tokenProvider.getDiscordBotToken())
        }
        return kord
    }
}