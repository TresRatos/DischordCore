package com.dischord.dagger

import dagger.Module
import dagger.Provides
import io.github.cdimascio.dotenv.dotenv
import javax.inject.Named
import javax.inject.Singleton

@Module
class Config {
    @Provides
    @Singleton
    @Named("BotToken")
    fun botToken(): String {
        val dotenv = dotenv()
        return dotenv["BOT_TOKEN"]
    }
}