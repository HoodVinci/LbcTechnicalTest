object Dependencies {

    private const val coroutinesVersion = "1.6.0"

    object GradlePlugins {
        const val androidBuildToolsGradlePlugin = "com.android.tools.build:gradle:7.1.2"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Config.kotlinVersion}"
    }

    object Testing {
        const val junit = "junit:junit:4.13.2"
        const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:4.0.0"
        const val truth = "com.google.truth:truth:1.1.3"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion"
    }

    object Coroutines {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    }

    object Serialization {
        const val Json = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2"
    }

}