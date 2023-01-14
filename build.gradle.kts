import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    dependencies {
        implementation("io.ktor:ktor-server-core:2.2.2")
        implementation("io.ktor:ktor-server-netty:2.2.2")
        implementation("io.ktor:ktor-client-core:2.2.2")
        implementation("io.ktor:ktor-client-cio:2.2.2")
        implementation("io.ktor:ktor-client-okhttp:2.2.2")
        implementation("io.ktor:ktor-client-logging:2.2.2")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}