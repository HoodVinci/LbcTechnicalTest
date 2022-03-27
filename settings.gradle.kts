rootProject.name = "LbcTechnicalTest"

include(":lbcapi:api", ":lbcapi:ktor", ":lbcapi:watchdog")
include(":local:api")
include(":domain")
include(":repositories")
include(":presentation")
include(":mobile")