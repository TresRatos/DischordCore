package com.dischord.dagger

import aws.sdk.kotlin.services.secretsmanager.SecretsManagerClient
import com.dischord.provider.BotTokenProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [DependencyModule::class])
class Config {
    @Provides
    @Singleton
    @Named("BotTokenProvider")
    fun botTokenProvider(client: SecretsManagerClient): BotTokenProvider {
        return BotTokenProvider(client)
    }
}