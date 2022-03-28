# Local Storage

## Api 
Api is a pure java module. It defines base interface and model for local storage.

## SimpleFile
This is an implementation of api module. Pure java module it relies on okio implementation which has
a neat api + it's multiplatform.

## Bench Application

This is a simple java application, it contains test suites for benching the local item store.
It's a simple way to have a very quick feedback on performance improvements. Plus it an be adapted to test 
a new implementation and compare it to previous one.
`./gradlew :local:benchapp:run`

