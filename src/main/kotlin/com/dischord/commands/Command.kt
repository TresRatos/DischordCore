package com.dischord.commands

import dev.kord.core.event.interaction.ChatInputCommandInteractionCreateEvent

interface Command {
    val name: String
    val description: String

    suspend fun handleInteraction(input: ChatInputCommandInteractionCreateEvent)
}