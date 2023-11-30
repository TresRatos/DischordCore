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

    // Logging
    implementation("io.github.oshai:kotlin-logging-jvm:5.1.0")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
