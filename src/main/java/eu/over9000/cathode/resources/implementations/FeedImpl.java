package eu.over9000.cathode.resources.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.Post;
import eu.over9000.cathode.data.PostBox;
import eu.over9000.cathode.data.PostList;
import eu.over9000.cathode.data.Reaction;
import eu.over9000.cathode.data.parameters.CursorPagination;
import eu.over9000.cathode.data.parameters.PostOptions;
import eu.over9000.cathode.data.parameters.ReactionOption;
import eu.over9000.cathode.resources.Feed;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

public class FeedImpl extends AbstractEndpoint implements Feed {

	public FeedImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<PostList> getPosts(final String channelName, final CursorPagination pagination) {
		return dispatcher.performGet(PostList.class, Feed.PATH + "/" + channelName, pagination);
	}

	@Override
	public Result<PostBox> postPost(final String channelName, final PostOptions options) {
		return dispatcher.performPost(PostBox.class, Feed.PATH + "/" + channelName, options == null ? null : new StringEntity(options.encode(), ContentType.APPLICATION_JSON));
	}

	@Override
	public Result<Post> getPost(final String channelName, final long postId) {
		return dispatcher.performGet(Post.class, Feed.PATH + "/" + channelName + "/" + postId);
	}

	@Override
	public Result<Void> deletePost(final String channelName, final long postId) {
		return dispatcher.performDelete(Void.class, Feed.PATH + "/" + channelName + "/" + postId);
	}

	@Override
	public Result<Reaction> postReaction(final String channelName, final long postId, final ReactionOption option) {
		return dispatcher.performPost(Reaction.class, Feed.PATH + "/" + channelName + "/" + postId, null, option);
	}

	@Override
	public Result<Void> deleteReaction(final String channelName, final long postId, final ReactionOption option) {
		return dispatcher.performDelete(Void.class, Feed.PATH + "/" + channelName + "/" + postId, option);
	}
}
