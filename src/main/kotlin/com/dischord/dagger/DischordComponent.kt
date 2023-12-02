package com.dischord.dagger

import com.dischord.commands.Command
import com.dischord.provider.KordClientProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    Config::class,
    DependencyModule::class,
    CommandModule::class,
])
interface DischordComponent {
    fun kordClientProvider(): KordClientProvider
    fun commands(): Set<Command>
}