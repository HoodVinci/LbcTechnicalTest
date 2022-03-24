plugins {
    id("jvm-app-conventions")
}

application {
    mainClass.set("com.hoodbrains.lbcapi.WatchdogKt")
}

dependencies {
    implementation(project(":lbcapi:ktor"))
}
