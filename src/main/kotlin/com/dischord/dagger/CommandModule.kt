package com.dischord.dagger

import com.dischord.activities.ActivityHandler
import com.dischord.commands.Command
import com.dischord.commands.Ping
import com.dischord.provider.KordClientProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [ActivityModule::class])
class CommandModule {
    @Provides
    @Singleton
    @Named("ping")
    fun pingCommand(
        kordClientProvider: KordClientProvider,
        @Named("PongHandler") pongHandler: ActivityHandler,
    ): Command {
        return Ping(
            kordClientProvider,
            pongHandler,
        )
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