import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
//    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.kotlin.jvm") version "1.3.61"
    id("org.openjfx.javafxplugin") version "0.0.7"
    application
}

group = "me.benjaminshinnick"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

javafx {
    modules = listOf("javafx.controls", "javafx.media", "javafx.graphics")
}

dependencies {
    implementation("junit:junit:4.13.1")
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("no.tornado:tornadofx:1.7.19")
    implementation("org.openjfx:javafx:11.0.2")
    implementation("org.openjfx:javafx-base:11.0.2")
    implementation("org.openjfx:javafx-controls:11.0.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClass.set("RunAppKT")
}