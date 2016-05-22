#Cathode
[Twitch-API v3](https://github.com/justintv/Twitch-API) wrapper written for Java 8 based on apache-httpclient and gson.

## Usage
Basic example that will print the 5 most popular games and their corresponding viewer number:
```java
final Twitch twitch = new Twitch(CLIENT_ID, AUTH_TOKEN);
twitch.games.getTopGames(new OffsetPagination(5)).ifOk(list -> list.getTop().forEach(game -> System.out.println(game.getGame().getName() + " = " + game.getViewers())));
```
You can check the unit tests for additional use examples.

Cathode is also used by [Skadi](https://github.com/s1mplex/skadi).

## Status
Covers the whole API. Barely any documentation, will hopefully change soon.
The API resources are accessible via the twitch object:
```java
public Channels channels;
public Chat chat;
public Feed feed;
public Games games;
public Ingests ingests;
public Root root;
public Streams streams;
public Search search;
public Teams teams;
public Users users;
public Videos videos;
```
Additionally two resources are available:
```java
public Undocumented undocumented;
public ImageUtil imageUtil;
```
These offer access to undocumented endpoints (atm only Panels) or respectively methods to directly retrieve images for a game, stream or other images (e.g. emotes)

## Licence
MIT licence, see [LICENCE](LICENCE) file.
