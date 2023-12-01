package com.dischord.dagger

import dagger.Component
import dev.kord.core.Kord
import javax.inject.Singleton

@Singleton
@Component(modules = [Config::class, DependencyModule::class])
interface DischordComponent {
    fun kordClient(): Kord
}