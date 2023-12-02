package com.dischord.dagger

import aws.sdk.kotlin.services.secretsmanager.SecretsManagerClient
import dagger.Module
import dagger.Provides
import dev.kord.core.Kord
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import kotlinx.coroutines.runBlocking
import javax.inject.Named
import javax.inject.Singleton

@Module
class DependencyModule {
    @Provides
    @Singleton
    fun createHttpClient(engine: HttpClientEngine): HttpClient {
        return HttpClient(engine) {
            expectSuccess = true
        }
    }

    @Provides
    @Singleton
    fun createSecretsManagerClient(): SecretsManagerClient {
        return SecretsManagerClient {}
    }

    @Provides
    @Singleton
    fun kordClient(
        @Named("BotToken") botToken: String,
    ): Kord {
        return runBlocking { Kord(botToken) }
    }
}