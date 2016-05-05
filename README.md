#Cathode
twitch.tv API wrapper written for Java 8 using on apache-httpclient and gson.

## Status
Covers the whole API except for the feed stuff, not really tested atm. Also barely any documentation, will hopefully change soon.

## Usage
See Main.java for usage examples, e.g.: 
```java
    final Twitch twitch = new Twitch(CLIENT_ID, AUTH_TOKEN);
	twitch.games.getTopGames(new OffsetPagination(5)).ifOk(list -> list.getTop().forEach(game -> System.out.println(game.getGame().getName() + " = " + game.getViewers())));
```
Will print the 5 most popular games and their viewer number.

## Licence
See [LICENCE](LICENCE)