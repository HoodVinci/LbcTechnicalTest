# Domain

This contains the application logic. This is were most of product owner rules will be implemented
and unit tested.

It is standalone, and should rely on almost no other libraries

# Use Case

A UseCase, is globally or a part of user's use case of the app. 

It's stateless, all states should be retrieved or stored through repositories.

A UseCase can use other use cases. 

There is no forced contract but a useCase should have a run method (suspendable or not)
with zero or more arguments, returning or not a result.

Try as much as possible to not deal with a coroutine scope or context, This is for implementation levels.

````kotlin
class FetchNameUseCase {
    suspend fun run(): String
}

````

A UseCase should not throw, NEVER. if the use case can fail type it and return it. kotlin.Result is a life saver !





