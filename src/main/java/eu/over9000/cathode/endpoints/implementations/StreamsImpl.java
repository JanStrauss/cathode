package eu.over9000.cathode.endpoints.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Response;
import eu.over9000.cathode.data.FeaturedStreamList;
import eu.over9000.cathode.data.StreamBox;
import eu.over9000.cathode.data.StreamList;
import eu.over9000.cathode.data.StreamSummary;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.StreamsQuery;
import eu.over9000.cathode.endpoints.Streams;

public class StreamsImpl extends AbstractEndpoint implements Streams {

	public StreamsImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Response<StreamBox> getStream() {
		return dispatcher.getAPIResponse(StreamBox.class, Streams.PATH);
	}

	@Override
	public Response<StreamBox> getStream(final String channelName) {
		return dispatcher.getAPIResponse(StreamBox.class, Streams.PATH + "/" + channelName);
	}

	@Override
	public Response<StreamSummary> getSummary() {
		return dispatcher.getAPIResponse(StreamSummary.class, Streams.PATH + "/summary");
	}

	@Override
	public Response<FeaturedStreamList> getFeatured(final OffsetPagination pagination) {
		return dispatcher.getAPIResponse(FeaturedStreamList.class, Streams.PATH + "/featured", pagination);
	}

	@Override
	public Response<StreamList> getStreams(final StreamsQuery query, final OffsetPagination pagination) {
		return dispatcher.getAPIResponse(StreamList.class, Streams.PATH, query, pagination);
	}

	@Override
	public Response<StreamList> getFollowed() {
		return null;
	}


}
