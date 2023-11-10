//
//plugins {
//    kotlin("jvm") version "1.9.0"
//    antlr
//}
//
//
//group = "org.example"
//version = "1.0-SNAPSHOT"
//
//repositories {
//    mavenCentral()
//}
//
//dependencies {
//    testImplementation(kotlin("test"))
//    implementation("org.antlr:antlr4:4.9.3")
//}
//
//tasks.test {
//    useJUnitPlatform()
//}
//
//kotlin {
//    jvmToolchain(8)
//}

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    kotlin("jvm") version "1.9.0"
    antlr
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.antlr:antlr4-runtime:4.13.1")
    antlr("org.antlr:antlr4:4.13.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.generateGrammarSource {
    arguments = arguments + listOf("-Werror", "-long-messages")
}

kotlin {
    jvmToolchain(8)
}

tasks.withType<KotlinCompile>().configureEach {
    dependsOn("generateGrammarSource")
}

tasks.getByName("compileKotlin").dependsOn("generateGrammarSource")
tasks.getByName("compileTestKotlin").dependsOn("generateTestGrammarSource")
