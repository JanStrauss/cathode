package eu.over9000.cathode;

import eu.over9000.cathode.data.QueriedStreams;
import eu.over9000.cathode.data.Stream;
import eu.over9000.cathode.data.parameters.Pagination;
import eu.over9000.cathode.data.parameters.StreamsQuery;

import java.util.List;
import java.util.function.Supplier;

public class Main {

	public static void main(final String[] args) {
		final Twitch twitch = new Twitch("i2uu9j43ure9x7n4ojpgg4hvcnw6y91");

		//twitch.channels.getChannel("sykpl3x").handle(System.out::println, Throwable::printStackTrace);
		//twitch.channels.getChannel("forsenlol").handle(System.out::println, Throwable::printStackTrace);

		//twitch.streams().getStream("forsenlol").handle(System.out::println, Throwable::printStackTrace);


		final Pagination pagination = new Pagination(100);
		final StreamsQuery query = new StreamsQuery("Dota 2", null, null, null);

		final Supplier<Response<QueriedStreams>> responseSupplier = () -> twitch.streams().getQuery(query, pagination);

		final Response<List<Stream>> q = Pagination.collectPaginated(pagination, responseSupplier);

		q.handle(list -> list.forEach(stream -> System.out.println(stream.getChannel().getName())), Throwable::printStackTrace);
	}
}