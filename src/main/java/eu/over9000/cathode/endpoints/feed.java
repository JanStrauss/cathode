package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.PostList;
import eu.over9000.cathode.data.parameters.CursorPagination;

/**
 * <pre>
 * /feed/:channel/posts                        GET
 * /feed/:channel/posts                        POST
 * /feed/:channel/posts/:id                    DELETE
 * /feed/:channel/posts/:id                    GET
 * /feed/:channel/posts/:id/reactions          DELETE
 * /feed/:channel/posts/:id/reactions          POST
 * </pre>
 */
public interface Feed {
	String PATH = "path";
	// TODO

	Result<PostList> getPosts(String channelName, CursorPagination pagination);

}
