An Android Application use github api to perform users search and display user profile.

# Libraries
* [Foundation][jetpack] - Components for core system capabilities, Kotlin extensions and support for
  multidex and automated testing.
  * [AppCompat][appcompat] - Degrade gracefully on older versions of Android.
  * [Android KTX][ktx] - Write more concise, idiomatic Kotlin code.
* [Architecture][arch] - A collection of libraries that help you design robust, testable, and
  maintainable apps. Start with classes for managing your UI component lifecycle and handling data
  persistence.
  * [LiveData][livedata] -  an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
  * [Navigation][navigation] - Handle everything needed for in-app navigation.
  * [ViewModel][viewmodel] - The Android framework manages the lifecycles of UI controllers,
* Third party and miscellaneous libraries
  * [Glide][glide] for image loading.
  * [Dagger 2][dagger2] for dependency injection.
  * [Retrofit][retrofit] for REST api communication.
  * [Kotlin Coroutines][coroutines] for managing background threads with simplified code and reducing needs for callbacks.
  
# TODO
* [Room][room] for local data source.
* Unit testing.

[jetpack]: https://developer.android.com/jetpack/components
[appcompat]: https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat
[ktx]: https://developer.android.com/kotlin/ktx
[arch]: https://developer.android.com/jetpack/arch/
[livedata]: https://developer.android.com/topic/libraries/architecture/livedata
[navigation]: https://developer.android.com/topic/libraries/architecture/navigation/
[viewmodel]: https://developer.android.com/topic/libraries/architecture/viewmodel
[glide]: https://bumptech.github.io/glide/
[coroutines]: https://kotlinlang.org/docs/reference/coroutines-overview.html
[room]: https://developer.android.com/topic/libraries/architecture/room
[support-lib]: https://developer.android.com/topic/libraries/support-library/index.html
[arch]: https://developer.android.com/arch
[dagger2]: https://google.github.io/dagger
[retrofit]: http://square.github.io/retrofit
[coroutines]: https://kotlinlang.org/docs/reference/coroutines-overview.html


# Build and Run

1. Download the project code, preferably using `git clone`.
2. Run project using command line or Android Studio

## 1. Android Studio
### Setup
To setup Android Studio, check [this](https://developer.android.com/studio/install)
### Import project
In Android Studio, select `File | Open...` and point to the `./build.gradle` file
### Build and run
To build and run app, check [this](https://developer.android.com/studio/run)

## 2. Command Line
To build and run app using command line, check [this](https://developer.android.com/studio/build/building-cmdline)