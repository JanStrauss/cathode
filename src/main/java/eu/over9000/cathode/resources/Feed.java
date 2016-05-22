/*
 * Copyright (c) 2016 s1mpl3x <jan[at]over9000.eu>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.over9000.cathode.resources;

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

	Result<Post> getPost(String channelName, String postId);

	Result<Void> deletePost(String channelName, String postId);

	Result<Reaction> postReaction(String channelName, String postId, ReactionOption option);

	Result<Void> deleteReaction(String channelName, String postId, ReactionOption option);
}
