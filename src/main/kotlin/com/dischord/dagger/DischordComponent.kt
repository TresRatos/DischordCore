package com.dischord.dagger

import bot.main.DischordBot
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    Config::class,
    DependencyModule::class,
    CommandModule::class,
    HandlerModule::class
])
interface DischordComponent {
    fun getBot(): DischordBot
}