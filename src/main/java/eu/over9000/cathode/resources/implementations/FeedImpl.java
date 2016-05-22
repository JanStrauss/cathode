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
		return dispatcher.performGet(PostList.class, Feed.PATH + "/" + channelName + "/posts", pagination);
	}

	@Override
	public Result<PostBox> postPost(final String channelName, final PostOptions options) {
		return dispatcher.performPost(PostBox.class, Feed.PATH + "/" + channelName + "/posts", options == null ? null : new StringEntity(options.encode(), ContentType.APPLICATION_JSON));
	}

	@Override
	public Result<Post> getPost(final String channelName, final String postId) {
		return dispatcher.performGet(Post.class, Feed.PATH + "/" + channelName + "/posts/" + postId);
	}

	@Override
	public Result<Void> deletePost(final String channelName, final String postId) {
		return dispatcher.performDelete(Void.class, Feed.PATH + "/" + channelName + "/posts/" + postId);
	}

	@Override
	public Result<Reaction> postReaction(final String channelName, final String postId, final ReactionOption option) {
		return dispatcher.performPost(Reaction.class, Feed.PATH + "/" + channelName + "/posts/" + postId + "/reactions", null, option);
	}

	@Override
	public Result<Void> deleteReaction(final String channelName, final String postId, final ReactionOption option) {
		return dispatcher.performDelete(Void.class, Feed.PATH + "/" + channelName + "/posts/" + postId + "/reactions", option);
	}
}
