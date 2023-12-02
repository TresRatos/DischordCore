package com.dischord.commands

import com.dischord.activities.ActivityHandler
import com.dischord.provider.KordClientProvider
import dev.kord.core.behavior.interaction.response.respond
import dev.kord.core.event.interaction.ChatInputCommandInteractionCreateEvent
import javax.inject.Inject

class Ping @Inject constructor(
    override val kordClientProvider: KordClientProvider,
    private val pongHandler: ActivityHandler
) : Command {
    override val name = "ping"
    override val description = "Ping!"

    override suspend fun handleInteraction(
        input: ChatInputCommandInteractionCreateEvent
    ) {
        val response = input.interaction.deferPublicResponse()
        response.respond { content = pongHandler.handleRequest().message }
    }
}