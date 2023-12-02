package com.dischord.provider

import aws.sdk.kotlin.services.secretsmanager.SecretsManagerClient
import aws.sdk.kotlin.services.secretsmanager.model.GetSecretValueRequest
import io.github.cdimascio.dotenv.dotenv
import javax.inject.Inject

class BotTokenProvider @Inject constructor(
    private val secretsManagerClient: SecretsManagerClient
) {
    suspend fun getDiscordBotToken(): String {
        val dotenv = dotenv()
        return dotenv["BOT_TOKEN"] ?: getTokenFromAws()
    }

    private suspend fun getTokenFromAws(): String {
        val request = GetSecretValueRequest {
            secretId = "DiscordBotKey"
        }
        return secretsManagerClient.getSecretValue(request).secretString
            ?: throw RuntimeException("Unable to fetch Discord API Key from secrets manager")
    }
}