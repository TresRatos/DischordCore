package com.dischord.dagger

import bot.main.DischordBot
import com.dischord.commands.Command
import com.dischord.commands.Ping
import com.dischord.handlers.Handler
import dagger.Module
import dagger.Provides
import dev.kord.core.Kord
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [HandlerModule::class])
class CommandModule {
    @Provides
    @Singleton
    fun createDischordBot(
        commands: Set<@JvmSuppressWildcards Command>,
        kord: Kord
    ): DischordBot {
        return DischordBot(commands, kord)
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