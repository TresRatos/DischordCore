package com.dischord.commands

import com.dischord.handlers.Handler
import dev.kord.core.behavior.interaction.response.respond
import dev.kord.core.event.interaction.ChatInputCommandInteractionCreateEvent
import javax.inject.Inject

class Ping @Inject constructor(
    private val pongHandler: Handler,
    override val name: String = "ping",
    override val description: String = "Ping!"
) : Command {
    override suspend fun handleInteraction(
        input: ChatInputCommandInteractionCreateEvent
    ) {
        val response = input.interaction.deferPublicResponse()
        response.respond { content = pongHandler.handleRequest().message }
    }
}