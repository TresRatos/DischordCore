val kotlin_version: String by project

plugins {
    kotlin("jvm") version "1.9.20"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.20"

    // Annotation Processing
    id("com.google.devtools.ksp") version "1.9.0-1.0.12"
}

group = "com.steamie"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    // Dagger Dependencies
    implementation("com.google.dagger:dagger:2.48.1")
    implementation("com.google.dagger:dagger-compiler:2.48.1")
    implementation("javax.inject:javax.inject:1")
    ksp("com.google.dagger:dagger-compiler:2.48")

    // Logging
    implementation("io.github.oshai:kotlin-logging-jvm:5.1.0")
    implementation("org.apache.logging.log4j:log4j-core:2.21.1")

    // Kord
    implementation("dev.kord:kord-core:0.12.0")

    // Aws Dependencies
    // https://mvnrepository.com/artifact/aws.sdk.kotlin/secretsmanager-jvm
    implementation("aws.sdk.kotlin:secretsmanager-jvm:0.33.1-beta")

    // ENV variable setter
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}