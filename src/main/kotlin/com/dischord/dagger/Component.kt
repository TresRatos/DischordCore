package com.dischord.dagger

import bot.main.DischordBot
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [Config::class])
interface DischordComponent {
    fun dischord(): DischordBot
}