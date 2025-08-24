plugins {
    kotlin("jvm") version "1.9.24"
    id("io.qameta.allure") version "2.12.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.codeborne:selenide:7.2.0")
    testRuntimeOnly("org.slf4j:slf4j-simple:2.0.13")
    testImplementation("io.qameta.allure:allure-junit5:2.29.1")
    testImplementation("io.qameta.allure:allure-selenide:2.29.1")

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}