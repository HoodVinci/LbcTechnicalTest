plugins {
    id("jvm-library-conventions")

}

dependencies {
    api(project(":local:api"))
    implementation(Dependencies.okio)
    implementation(Dependencies.Serialization.Json)
}