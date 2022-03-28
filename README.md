# Lbc Technical Test

## Versioning

Project is versioned under Git. Let's try as much as possible to follow commit msg formatting
described [here](http://karma-runner.github.io/1.0/dev/git-commit-msg.html).

## Building
Project uses gradle for building and for dependency management. In order to smooth modularization.
It uses precompiled gradle plugins. 
[more here ](https://docs.gradle.org/current/userguide/custom_plugins.html#sec:precompiled_plugins).


## CI/CD
A github action is configured to run Unit tests on every change to main or on any branch on which a pull request is opened targeting main.

There is also, a standalone job, runnable on demand that operates sanity checks on server endpoint. 

## Architectures Principles:  Clean architecture and MVVM

Application is split in modules, each one with clearly stated and limited in scope.
Each module should have the smallest possible number of reasons to change. For instance LbcApi:Api 
will only change if the contract with the server change.

Modules that can be pure java, shouldn't be android. Everything is smoother and easier, compilation, testing...
And it offers opportunities to create standalone java apps, to bench or do integration tests easily runnable by every CI server.
Lastly it open a door on a shared multiplatform library extraction.

Finally, in order to have a presentation layer agnostic of the view presenting. MVVM has been implemented.

## Modules
[Domain](./domain/README.md)

[Repositories](./repositories/README.md)

[Mobile Application](./mobile/README.md)

[LbcApi](./lbcapi/README.md)

[Local](./local/README.md)


## Possible next steps

__Handling navigation in domain layer__ The AppState machine way

__Handling use interaction in view models__ Avoid passing callback through view layers (activity, fragments, adapters ...) and pass a generic callback tied to presentation items.

__Entities builders in domain module__ Let the domain choose default values on construction and have a chance to reconcile data.

__Kotlin Multiplatform__ A shared module including presentation.

