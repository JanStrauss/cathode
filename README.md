#Cathode

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/eu.over9000/cathode/badge.svg)](https://maven-badges.herokuapp.com/maven-central/eu.over9000/cathode)

[Twitch-API v3](https://github.com/justintv/Twitch-API) library written for/in Java 8. Based on apache-httpclient and gson.

## Usage
Add Cathode as a dependency using Maven:
```xml
<dependency>
  <groupId>eu.over9000</groupId>
  <artifactId>cathode</artifactId>
  <version>1.1</version>
</dependency>
```
Or see [releases](https://github.com/s1mpl3x/cathode/releases).

Basic example that will print the 5 most popular games and their corresponding viewer number:
```java
Twitch twitch = new Twitch(CLIENT_ID, AUTH_TOKEN);
Result<TopGameList> result = twitch.games.getTopGames(new OffsetPagination(5));
result.ifOk(list -> list.getTop().forEach(game -> System.out.println(game.getGame().getName() + " = " + game.getViewers())));
```
You can check the unit tests for additional usage examples.
Cathode is also used by [Skadi](https://github.com/s1mplex/skadi).

### Structure
The twitch object is the central access point to the API resources (e.g. users, videos, channels, streams, chat). 

### Result class
The endpoints of the resources implemented by methods that return a `Result<Type>`. The Result class is a wrapper inspired by Rust's std::result::Result. A Result can either be OK (and contain an object of the wrapped class) or can be in a ERROR state (containing an exception). Using this approach to error handling allows for a more flexible API (see below) and is, imho, cleaner and easier to use. There are different methods to access the wrapped object:

#### Callback
You provide callbacks that are called if the Result is in the corresponding state
* `Result<Type> ifOk(final Consumer<Type> callback)`
* `Result<Type> ifError(final Consumer<Type> callback)`
* `void handle(final Consumer<Type> callbackOk, final Consumer<Throwable> callbackError)`

#### Optional
A Result can be converted into an Optional
* `Optional<Type> asOptional()`

#### Exception 
Rethrows the exception if present or returns the wrapped object
* `Type getOrException() throws Exception`

#### Raw access
Check if in OK state via `boolean isOk()` and then use the raw accessors
* `Type getResultRaw()`
* `Throwable getErrorRaw()`

## Status
Covers the whole API. Barely any documentation, will hopefully change soon.
Cathode provides two additional API resources,`undocumented` and `imageUtil`. These offer access to undocumented endpoints (atm only Panels) or respectively methods to directly retrieve images for a game, stream or other images (e.g. emotes)

## Licence
MIT licence, see [LICENCE](LICENCE) file.
