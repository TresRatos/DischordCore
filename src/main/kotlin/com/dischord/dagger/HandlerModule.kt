package com.dischord.dagger

import com.dischord.handlers.Handler
import com.dischord.handlers.PongHandler
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [Config::class])
class HandlerModule {
    @Provides
    @Singleton
    @Named("PongHandler")
    fun pongHandler(): Handler {
        return PongHandler()
    }
}