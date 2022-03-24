plugins {
    id("jvm-library-conventions")
    kotlin("plugin.serialization") version Config.kotlinVersion
}

dependencies {
    implementation(Dependencies.Serialization.Json)
}