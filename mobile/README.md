# Mobile Application


# Injection and factories

Application (LbcTestApp) is the main entry point of the app and hence is in charge of assembling all 
pieces of software in order to produce notably the viewModel factory. This is delegated to class 
AppDependenciesProvider

We do use a fragment factory [here](https://developer.android.com/reference/androidx/fragment/app/FragmentFactory) to inject fragments,
and a ViewModelProvider.Factory for view models.
So the only objects we have to inject (not by construction) are activities, we did use an injection through application. (and no framework)

# UI And Breakpoints

We decided to consider devices which smallest width in points is at least at 320dp.
(there is only a very very few of ever sold devices not matching this requirement).

Always in points of the current width (dp), we have two breakpoints. Giving us the opportunity to adapt the UI.

We decided to put these breakpoints to 600 and 900dp. 
This almost match [this](https://developer.android.com/guide/topics/large-screens/support-different-screen-sizes#window_size_classes)
As our views are scrollable we don't take care of height.

Designers must provide their mock-ups, at  320, 600, 900 pixels. like these all Ui choices, text size,
element sizes, have been made in the worst case for each category. 

To ease the process of creating emulators, device profiles have been versioned [here](./device_profiles)

