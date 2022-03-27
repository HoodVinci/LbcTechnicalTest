plugins {
    id("jvm-app-conventions")
}

application {
    mainClass.set("com.hoodbrains.lbctest.local.LocalBenchAppKt")
}

dependencies {
    implementation(project(":local:simplefile"))
}
