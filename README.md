#Cathode

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/eu.over9000/cathode/badge.svg)](https://maven-badges.herokuapp.com/maven-central/eu.over9000/cathode)

[Twitch-API v3](https://github.com/justintv/Twitch-API) wrapper written for Java 8 based on apache-httpclient and gson.

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
final Twitch twitch = new Twitch(CLIENT_ID, AUTH_TOKEN);
twitch.games.getTopGames(new OffsetPagination(5)).ifOk(list -> list.getTop().forEach(game -> System.out.println(game.getGame().getName() + " = " + game.getViewers())));
```
You can check the unit tests for additional use examples.
Cathode is also used by [Skadi](https://github.com/s1mplex/skadi).

### Structure
The twitch object is the central access point to the API resources (e.g. users, videos, channels, streams, chat). 

### Result class
The endpoints of the resources implemented by methods that return a `Result<Type>` where Type is a POJO modelling the JSON response, e.g. a `Result<Channel>` for the `twitch.channels.getChannel(String channelName)` method. The Result class is a wrapper similar to Java's [Optional](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html). A Result can either be OK or can be in a ERROR state. There are different methods to access the wrapped object:

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
