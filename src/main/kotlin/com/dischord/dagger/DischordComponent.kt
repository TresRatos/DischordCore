package com.dischord.dagger

import com.dischord.provider.KordClientProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [Config::class, DependencyModule::class])
interface DischordComponent {
    fun kordClient(): KordClientProvider
}