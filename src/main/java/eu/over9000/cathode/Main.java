package eu.over9000.cathode;

import eu.over9000.cathode.data.Follow;
import eu.over9000.cathode.data.FollowList;
import eu.over9000.cathode.data.Stream;
import eu.over9000.cathode.data.StreamList;
import eu.over9000.cathode.data.parameters.*;

import java.util.List;
import java.util.function.Supplier;

public class Main {

	public static void main(final String[] args) {
		final Twitch twitch = new Twitch("i2uu9j43ure9x7n4ojpgg4hvcnw6y91");

		//twitch.channels.getChannel().print();
		//twitch.channels.getChannel("forsenlol").handle(System.out::println, Throwable::printStackTrace);
		//twitch.streams.getStream("forsenlol").handle(System.out::println, Throwable::printStackTrace);


		//tryOffsetPagination(twitch);
		//tryCursorPagination(twitch);

		//tryIngests(twitch);

		//tryChat(twitch);

		//tryFeed(twitch);

		//tryGames(twitch);

		//tryRoot(twitch);

		trySearch(twitch);
	}

	private static void trySearch(Twitch twitch) {

		twitch.search.getChannels(new SearchChannelOptions("forsen"), new OffsetPagination(10)).print();
		twitch.search.getGames(new SearchGamesOptions("battlefield")).print();
		twitch.search.getStreams(new SearchStreamsOptions("previouslyrecorded"), new OffsetPagination(10)).print();

	}

	private static void tryRoot(Twitch twitch) {
		twitch.root.getRoot().print();
	}

	private static void tryGames(Twitch twitch) {
		OffsetPagination p = new OffsetPagination(25);
		twitch.games.getTopGames(p).ifOk(list -> list.getTop().forEach(game -> System.out.println(game.getGame().getName() + " = " + game.getViewers())));
	}

	private static void tryFeed(final Twitch twitch) {
		final CursorPagination p = new CursorPagination(5);
		twitch.feed.getPosts("djWHEAT", p).print();
	}

	private static void tryChat(final Twitch twitch) {
		twitch.chat.getBadges("forsenlol").handle(System.out::println, Throwable::printStackTrace);
		twitch.chat.getEmoticons("forsenlol").handle(System.out::println, Throwable::printStackTrace);
		twitch.chat.getEmoticons().handle(x -> {
			System.out.println(x.getEmoticons().size());
		}, Throwable::printStackTrace);

		twitch.chat.getEmoticonImages(new Emotesets("128", "77", "5993")).handle(System.out::println, Throwable::printStackTrace);
	}

	private static void tryIngests(final Twitch twitch) {
		twitch.ingests.getIngests().ifOk(ingestList -> ingestList.getIngests().forEach(System.out::println));
	}


	private static void tryCursorPagination(final Twitch twitch) {
		final CursorPagination pagination = new CursorPagination(75);

		final Supplier<Result<FollowList>> responseSupplier = () -> twitch.channels.getFollows("oluwakanyins", pagination, null);

		final Result<List<Follow>> q = Pagination.collectPaginated(pagination, responseSupplier);

		q.handle(list -> list.forEach(follow -> System.out.println(follow.getUser().getDisplayName())), Throwable::printStackTrace);
	}

	private static void tryOffsetPagination(final Twitch twitch) {
		final OffsetPagination pagination = new OffsetPagination(100);
		final StreamsQuery query = new StreamsQuery("Dota 2", null, null, null);

		final Supplier<Result<StreamList>> responseSupplier = () -> twitch.streams.getStreams(query, pagination);

		final Result<List<Stream>> q = Pagination.collectPaginated(pagination, responseSupplier);

		q.handle(list -> list.forEach(stream -> System.out.println(stream.getChannel().getName())), Throwable::printStackTrace);
	}
}