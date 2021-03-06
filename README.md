# Android Networking Example (WIP)

This is an example of basic data fetching from network done in many ways on Android.

All example will fetch `Users` data from https://jsonplaceholder.typicode.com/users, and display it on a list. There will be a loading indicator while fetching the data, and it'll shows a toast if an error happens.

Each example has it's own activity, under certain package name reflecting its category.

### Package Structure

- Common
- Simple
    - asynchttp
    - url
    - retrofit
        - callback
        - coroutine
        - rxjava
- Standard
    - mvp
        - coroutine
        - rxjava
    - mvvm
        - coroutine
        - rxjava
- Advanced
    - coroutine
    - pepe

#### Common

Common code for all example, contains :
- Response Model from https://jsonplaceholder.typicode.com/users
- Constants
- BaseActivity
   - abstracting code for setting up recycler view, show / hide loading & toast
- UserAdapter
    - adapter for user list
- Extensions

#### Simple

The aim here is just to straightforwardly fetch a remote data on various networking library that are available and various async work method (asynctask, callback, rx, coroutine), using the minimum amount of effort to setup the networking code.

#### Standard

This category follows basic separation of concerns with presentational pattern, in this case MVP and MVVM. It uses Retrofit as networking library and Rxjava or Coroutine for async work.

#### Advanced

This category took the standard to the next level. It applies architectural pattern which separate each responsibility into its own layer. Currently this contains two sub-category:

1. Advanced Coroutine (without DI), which follows Uncle Bob's Clean Architecture along with MVVM pattern, Retrofit for networking & Coroutine to do async work.
2. _Pepe_ Arch, a homebrew architecture used by one of the leading online travel agent company in Indonesia


### TODO

More Network Client
- [ ] Fast Android Networking
- [ ] Fuel
- [ ] more...

More Case
- [ ] Consecutive / chained network calls
- [ ] Proper REST Api HTTP code handling
- [ ] Syntactic Sugar with extensions for some featured example
- [ ] Offline-first app (Single Source of Truth data)

