plugins {
    id("android-app-conventions")
    kotlin("kapt")
}

android {
    defaultConfig {
        applicationId = "com.hoodbrains.lbctest"
        versionCode = 1
        versionName = "0.1.0"
    }
}

dependencies {
    implementation(project(":presentation"))
    implementation(project(":lbcapi:ktor"))
    implementation(project(":repositories"))
    implementation(Dependencies.Glide.core)
    kapt(Dependencies.Glide.compiler)
}
