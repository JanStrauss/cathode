package eu.over9000.cathode;

import eu.over9000.cathode.data.Follow;
import eu.over9000.cathode.data.FollowList;
import eu.over9000.cathode.data.Stream;
import eu.over9000.cathode.data.StreamList;
import eu.over9000.cathode.data.parameters.CursorPagination;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.Pagination;
import eu.over9000.cathode.data.parameters.StreamsQuery;

import java.util.List;
import java.util.function.Supplier;

public class Main {

	public static void main(final String[] args) {
		final Twitch twitch = new Twitch("i2uu9j43ure9x7n4ojpgg4hvcnw6y91");

		twitch.channels.getChannel("sykpl3x").handle(System.out::println, Throwable::printStackTrace);
		twitch.channels.getChannel("forsenlol").handle(System.out::println, Throwable::printStackTrace);
		twitch.streams.getStream("forsenlol").handle(System.out::println, Throwable::printStackTrace);


		tryOffsetPagination(twitch);
		tryCursorPagination(twitch);

		tryIngests(twitch);
	}

	private static void tryIngests(final Twitch twitch) {
		twitch.ingests.getIngests().ifOk(ingestList -> ingestList.getIngests().forEach(System.out::println));
	}


	private static void tryCursorPagination(final Twitch twitch) {
		final CursorPagination pagination = new CursorPagination(75);

		final Supplier<Result<FollowList>> responseSupplier = () -> twitch.channels.getFollows("oluwakanyins", pagination);

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