package com.dischord.activities

import javax.inject.Inject

class PongHandler @Inject constructor(
): ActivityHandler {

    override fun handleRequest(): ActivityResponse {
        return ActivityResponse(
            message = "Pong!"
        )
    }
}