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
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    }

    object Serialization {
        const val Json = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2"
    }

    object AndroidX {
        const val lifecycleLivedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
        const val coreKtx = "androidx.core:core-ktx:1.6.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.3.6"
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.1"
    }

    object Ktor {
        private const val ktorVersion = "1.6.8"
        const val core = "io.ktor:ktor-client-core:$ktorVersion"

        const val clientCio = "io.ktor:ktor-client-cio:$ktorVersion"
        const val serialization = "io.ktor:ktor-client-serialization:$ktorVersion"
        const val clientLogging = "io.ktor:ktor-client-logging:$ktorVersion"
    }

    object Glide {
        private const val glideVersion = "4.12.0"
        const val core = "com.github.bumptech.glide:glide:$glideVersion"
        const val compiler = "com.github.bumptech.glide:compiler:$glideVersion"
    }

    const val material = "com.google.android.material:material:1.4.0"
    const val okio = "com.squareup.okio:okio:3.0.0"

}