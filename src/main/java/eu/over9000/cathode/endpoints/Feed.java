package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.PostList;
import eu.over9000.cathode.data.parameters.CursorPagination;

/**
 * <pre>
 * /feed/:channel/posts                        GET		getPosts(String channelName, CursorPagination pagination);
 * /feed/:channel/posts                        POST		// TODO
 * /feed/:channel/posts/:id                    DELETE	// TODO
 * /feed/:channel/posts/:id                    GET		// TODO
 * /feed/:channel/posts/:id/reactions          DELETE	// TODO
 * /feed/:channel/posts/:id/reactions          POST		// TODO
 * </pre>
 */
public interface Feed {
	String PATH = "path";

	Result<PostList> getPosts(String channelName, CursorPagination pagination);

}
