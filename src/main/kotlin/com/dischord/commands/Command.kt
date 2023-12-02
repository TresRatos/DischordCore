package com.dischord.commands

import com.dischord.provider.KordClientProvider
import dev.kord.core.event.interaction.ChatInputCommandInteractionCreateEvent

interface Command {
    val kordClientProvider: KordClientProvider
    val name: String
    val description: String

    suspend fun register() {
        println("Registering Command $name, with description: $description")
        val kordClient = kordClientProvider.getKordClient()
        kordClient.createGlobalChatInputCommand(
            // Discord throws an error if the command name is now all lowercase
            name = name,
            description = description,
        ) {}
        println("Registered Command $name, with description: $description")
    }

    suspend fun handleInteraction(input: ChatInputCommandInteractionCreateEvent)
}