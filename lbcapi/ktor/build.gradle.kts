plugins {
    id("jvm-library-conventions")

}

dependencies {
    api(project(":lbcapi:api"))
    implementation(Dependencies.Ktor.core)
    implementation(Dependencies.Ktor.serialization)
    implementation(Dependencies.Ktor.clientCio)
    implementation(Dependencies.Ktor.clientLogging)
}