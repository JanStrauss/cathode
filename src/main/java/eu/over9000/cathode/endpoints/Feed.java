package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.Post;
import eu.over9000.cathode.data.PostBox;
import eu.over9000.cathode.data.PostList;
import eu.over9000.cathode.data.Reaction;
import eu.over9000.cathode.data.parameters.CursorPagination;
import eu.over9000.cathode.data.parameters.PostOptions;
import eu.over9000.cathode.data.parameters.ReactionOption;

/**
 * <pre>
 * /feed/:channel/posts                        GET		getPosts(String channelName, CursorPagination pagination);
 * /feed/:channel/posts                        POST		postPost(String channelName, PostOptions options);
 * /feed/:channel/posts/:id                    DELETE	deletePost(String channelName, long postId);
 * /feed/:channel/posts/:id                    GET		getPost(String channelName, long postId);
 * /feed/:channel/posts/:id/reactions          DELETE	deleteReaction(String channelName, long postId, ReactionOption option);
 * /feed/:channel/posts/:id/reactions          POST		postReaction(String channelName, long postId, ReactionOption option);
 * </pre>
 */
public interface Feed {
	String PATH = "feed";

	Result<PostList> getPosts(String channelName, CursorPagination pagination);

	Result<PostBox> postPost(String channelName, PostOptions options);

	Result<Post> getPost(String channelName, long postId);

	Result<Void> deletePost(String channelName, long postId);

	Result<Reaction> postReaction(String channelName, long postId, ReactionOption option);

	Result<Void> deleteReaction(String channelName, long postId, ReactionOption option);
}
