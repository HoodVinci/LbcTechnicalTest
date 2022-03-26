plugins {
    id("jvm-library-conventions")
}

dependencies {
    api(project(":domain"))
    api(project(":lbcapi:api"))
}