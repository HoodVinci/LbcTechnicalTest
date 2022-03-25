# Presentation

Every view model is provided through view model factory. This is the entry point of the module.

## Design Principles

### View States
The state of the presentation for every view model is clearly stated through children of sealed class

```kotlin
sealed class RelevantNameViewState {
    object Loading : RelevantNameViewState()
    data class Data(data: String) : RelevantNameViewState()
    object Error : RelevantNameViewState()
}
```

### Streams 

This stream of different states is exposed through a coroutines Flow and not an android Livedata for 3 main reasons :
 - Tooling on flow ( distinctUntilChanged(), filter, onEach...) is a life saver.
 - Testing Flows is way easier than LiveData's.
 - It opens doors on a shared  multiplatform presentation module.

```kotlin
interface RelevantNameViewModel {
    fun start(): Flow<RelevantNameViewState>
}
```
### Resources

If view model relies on strings/ drawable ids .... embedded in application. These are injected at construction by the application.
It enforces :
- Scoping : View model does not have access to the WHOLE WORLD resources. 
- Testing : no android build file to mock. it's classic and easier.
- Reuse : think of sharing presentation between tv and module. Wordings might be slightly different for instance.

