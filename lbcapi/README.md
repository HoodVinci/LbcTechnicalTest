# LbcApi

api module defines strictly the interface of the remote server model and defines its endpoints.
api is a pure java module.

ktor module is an implementation of public api base on ktor library
ktor is a pure java module.

Watchdog is a java application that uses api to operate some sanity checks. 
It checks parts of the contract with server, that cannot be checked only by type checking :
- Non empty fields
- items unicity
- and every implicit contract ...
It's intended to be run often with `./gradlew :lbcapi:watchdog:run`
It's also a good integrated tests for our module and can be used to iterate fast on development phases.  


