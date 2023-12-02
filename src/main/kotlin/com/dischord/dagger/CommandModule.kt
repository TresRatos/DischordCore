package com.dischord.dagger

import bot.main.KordClient
import com.dischord.commands.Command
import com.dischord.commands.Ping
import com.dischord.handlers.Handler
import com.dischord.provider.BotTokenProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [HandlerModule::class])
class CommandModule {
    @Provides
    @Singleton
    fun createKordClient(
        @Named("BotTokenProvider") botTokenProvider: BotTokenProvider,
        commands: Set<@JvmSuppressWildcards Command>
    ): KordClient {
        return KordClient(botTokenProvider, commands)
    }

    @Provides
    @Singleton
    @Named("ping")
    fun pingCommand(
        @Named("PongHandler") pongHandler: Handler,
    ): Command {
        return Ping(pongHandler)
    }

    @Provides
    @Singleton
    fun commands(
        @Named("ping") pingCommand: Command
    ): Set<Command> {
        return setOf(
            pingCommand
        )
    }
}