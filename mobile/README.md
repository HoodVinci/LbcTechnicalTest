# Mobile Application


# Injection and factories

Application (LbcTestApp) is the main entry point of the app and hence is in charge of assembling all 
pieces of software in order to produce notably the viewModel factory. This is delegated to class 
AppDependenciesProvider

We do use a fragment factory [here](https://developer.android.com/reference/androidx/fragment/app/FragmentFactory) to inject fragments,
and a ViewModelProvider.Factory for view models.
So the only objects we have to inject (not by construction) are activities, we did use an injection through application. (and no framework)


