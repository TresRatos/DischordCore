package com.dischord.dagger

import aws.sdk.kotlin.services.secretsmanager.SecretsManagerClient
import com.dischord.provider.BotTokenProvider
import com.dischord.provider.KordClientProvider
import dagger.Module
import dagger.Provides
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
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
    fun createKordClientProvider(
        @Named("BotTokenProvider") botTokenProvider: BotTokenProvider,
    ): KordClientProvider {
        return KordClientProvider(botTokenProvider)
    }
}