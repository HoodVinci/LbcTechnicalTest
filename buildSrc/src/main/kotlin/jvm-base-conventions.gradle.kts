import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = Config.jvmTarget
}

dependencies {
    implementation(Dependencies.Coroutines.coroutinesCore)
    testImplementation(Dependencies.Testing.junit)
    testImplementation(Dependencies.Testing.mockitoKotlin)
    testImplementation(Dependencies.Testing.truth)
    testImplementation(Dependencies.Testing.coroutinesTest)
}

