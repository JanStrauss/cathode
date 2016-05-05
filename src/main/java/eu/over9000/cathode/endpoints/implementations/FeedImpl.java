package eu.over9000.cathode.endpoints.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.PostList;
import eu.over9000.cathode.data.parameters.CursorPagination;
import eu.over9000.cathode.endpoints.Feed;

/**
 * Created by Jan on 05.05.2016.
 */
public class FeedImpl extends AbstractEndpoint implements Feed {

	public FeedImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<PostList> getPosts(final String channelName, final CursorPagination pagination) {
		return dispatcher.getAPIResponse(PostList.class, Feed.PATH + "/" + channelName, pagination);
	}
}
