package com.dischord.handlers

import javax.inject.Inject

class PongHandler @Inject constructor(
): Handler {

    override fun handleRequest(): HandlerResponse {
        return HandlerResponse(
            message = "Pong!"
        )
    }
}