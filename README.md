#Cathode
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

## Status
Covers the whole API. Barely any documentation, will hopefully change soon.
Cathode provides two additional API resources,`undocumented` and `imageUtil`. These offer access to undocumented endpoints (atm only Panels) or respectively methods to directly retrieve images for a game, stream or other images (e.g. emotes)

## Licence
MIT licence, see [LICENCE](LICENCE) file.
