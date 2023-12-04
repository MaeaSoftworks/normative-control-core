import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.0.0-Beta1"
    id("com.github.ben-manes.versions") version "0.50.0"
}

kotlin {
    sourceSets.all {
        languageSettings {
            languageVersion = "2.0"
        }
    }
}

allprojects {
    repositories {
        mavenCentral()
    }

    group = "ru.maeasoftworks"
    version = "1.0"

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "20"
        }
    }
}