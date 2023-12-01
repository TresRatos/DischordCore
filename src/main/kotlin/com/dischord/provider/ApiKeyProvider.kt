package com.dischord.provider

import aws.sdk.kotlin.services.secretsmanager.SecretsManagerClient
import aws.sdk.kotlin.services.secretsmanager.model.GetSecretValueRequest
import java.lang.RuntimeException
import javax.inject.Inject

class ApiKeyProvider @Inject constructor(
    private val secretsManagerClient: SecretsManagerClient
) {
    suspend fun getDiscordApiKey(): String {
        val request = GetSecretValueRequest {
            secretId = "DiscordApiKey"
        }
        return secretsManagerClient.getSecretValue(request).secretString
            ?: throw RuntimeException("Unable to fetch Discord API Key from secrets manager")
    }
}