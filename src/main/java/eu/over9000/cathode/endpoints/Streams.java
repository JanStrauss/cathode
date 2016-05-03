package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Response;
import eu.over9000.cathode.data.*;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.StreamsQuery;

public interface Streams {

	String PATH = "streams";
	/*
		-GET 	/streams/:channel/ 		Get stream object
		-GET 	/streams 				Get stream object
		-GET 	/streams/featured 		Get a list of featured streams
		-GET 	/streams/summary 		Get a summary of streams
		-GET 	/streams/followed 		Get a list of streams user is following
	 */

	Response<StreamBox> getStream(final String channelName);

	Response<StreamSummary> getSummary();

	Response<FeaturedStreams> getFeatured(OffsetPagination pagination);

	Response<QueriedStreams> getQuery(StreamsQuery query, OffsetPagination pagination);

	Response<Follows> getFollows();

}