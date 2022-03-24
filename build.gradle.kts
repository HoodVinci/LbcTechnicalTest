plugins {}

buildscript {
    repositories {
        mavenCentral()
        google()
    }

    dependencies {
        classpath(Dependencies.GradlePlugins.androidBuildToolsGradlePlugin)
        classpath(Dependencies.GradlePlugins.kotlinGradlePlugin)
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
    }
}



