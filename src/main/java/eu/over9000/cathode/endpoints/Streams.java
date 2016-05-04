package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.FeaturedStreamList;
import eu.over9000.cathode.data.StreamBox;
import eu.over9000.cathode.data.StreamList;
import eu.over9000.cathode.data.StreamSummary;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.StreamsQuery;

/**
 * <pre>
 * /streams                                    GET
 * /streams/:channel/                          GET
 * /streams/featured                           GET
 * /streams/followed                           GET
 * /streams/summary                            GET
 * </pre>
 */
public interface Streams {

	String PATH = "streams";

	//	-GET 	/streams 				Get stream object
	Result<StreamBox> getStream();

	//	-GET 	/streams/:channel/ 		Get stream object
	Result<StreamBox> getStream(String channelName);

	//	-GET 	/streams/summary 		Get a summary of streams
	Result<StreamSummary> getSummary();

	//	-GET 	/streams/featured 		Get a list of featured streams
	Result<FeaturedStreamList> getFeatured(OffsetPagination pagination);

	Result<StreamList> getStreams(StreamsQuery query, OffsetPagination pagination);

	//	-GET 	/streams/followed 		Get a list of streams user is following
	Result<StreamList> getFollowed();

}