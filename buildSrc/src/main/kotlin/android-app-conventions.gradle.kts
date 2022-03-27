plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = Config.Android.compileSdkVersion

    defaultConfig {
        targetSdk = Config.Android.targetSdkVersion
        minSdk = Config.Android.minSdkVersion
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }

}

dependencies {
    implementation(Dependencies.Coroutines.android)

    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.fragmentKtx)
    implementation(Dependencies.AndroidX.legacySupport)
    implementation(Dependencies.AndroidX.lifecycleLivedataKtx)
    implementation(Dependencies.material)

    testImplementation(Dependencies.Testing.truth)
    testImplementation(Dependencies.Testing.junit)
    testImplementation(Dependencies.Testing.mockitoKotlin)
    testImplementation(Dependencies.Testing.coroutinesTest)
}

