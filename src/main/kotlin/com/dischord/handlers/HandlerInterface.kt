package com.dischord.handlers

open class HandlerResponse(
    val message: String
)

interface Handler {
    fun handleRequest(): HandlerResponse
}