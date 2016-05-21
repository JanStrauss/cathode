#Cathode
[Twitch-API v3](https://github.com/justintv/Twitch-API) wrapper written for Java 8 based on apache-httpclient and gson.

## Status
Covers the whole API except for the feed stuff. Barely any documentation, will hopefully change soon.

## Usage
See Main.java for usage examples, e.g.: 
```java
    final Twitch twitch = new Twitch(CLIENT_ID, AUTH_TOKEN);
	twitch.games.getTopGames(new OffsetPagination(5)).ifOk(list -> list.getTop().forEach(game -> System.out.println(game.getGame().getName() + " = " + game.getViewers())));
```
Will print the 5 most popular games and their viewer number.

The endpoints of the API are accessible via the twitch object:
```java
public Channels channels;
public Chat chat;
public Feed feed; // TODO
public Games games;
public Ingests ingests;
public Root root;
public Streams streams;
public Search search;
public Teams teams;
public Users users;
public Videos videos;
```
Additionally two more endpoints are available: 	
```java
public Undocumented undocumented;
public ImageUtil imageUtil;
```
offering access to undocumented endpoints (atm only Panels) or respectively methods to directly retrieve images for a game, stream or other images (e.g. emotes)

cathode is also used by [Skadi](https://github.com/s1mplex/skadi).

## Licence
See [LICENCE](LICENCE)
