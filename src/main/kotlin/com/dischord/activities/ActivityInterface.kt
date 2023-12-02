package com.dischord.activities

open class ActivityResponse(
    val message: String
)

interface ActivityHandler {
    fun handleRequest(): ActivityResponse
}