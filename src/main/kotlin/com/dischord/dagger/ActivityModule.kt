package com.dischord.dagger

import com.dischord.activities.ActivityHandler
import com.dischord.activities.PongHandler
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ActivityModule {
    @Provides
    @Singleton
    @Named("PongHandler")
    fun pongHandler(
    ): ActivityHandler {
        return PongHandler()
    }
}