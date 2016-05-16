/*
 * Copyright (c) 2014-2016 s1mpl3x <jan[at]over9000.eu>
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

package eu.over9000.cathode.endpoints.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.*;
import eu.over9000.cathode.data.parameters.Direction;
import eu.over9000.cathode.data.parameters.GetFollowsSortBy;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.PutFollowsOptions;
import eu.over9000.cathode.endpoints.Users;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

public class UsersImpl extends AbstractEndpoint implements Users {
	public UsersImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<User> getUser() {
		return dispatcher.performGet(User.class, "user");
	}

	@Override
	public Result<User> getUser(final String userName) {
		return dispatcher.performGet(User.class, Users.PATH + "/" + userName);
	}

	@Override
	public Result<BlockList> getBlocks(final String userName) {
		return dispatcher.performGet(BlockList.class, Users.PATH + "/" + userName + "/blocks");
	}

	@Override
	public Result<Void> deleteBlock(final String userName, final String targetName) {
		return dispatcher.performDelete(Void.class, Users.PATH + "/" + userName + "/blocks/" + targetName);
	}

	@Override
	public Result<Block> putBlock(final String userName, final String targetName) {
		return dispatcher.performPut(Block.class, Users.PATH + "/" + userName + "/blocks/" + targetName, null);
	}

	@Override
	public Result<FollowList> getFollows(final String userName, final OffsetPagination pagination, final Direction direction, final GetFollowsSortBy sortBy) {
		return dispatcher.performGet(FollowList.class, Users.PATH + "/" + userName + "/follows/channels", pagination, direction, sortBy);
	}

	@Override
	public Result<Follow> getFollows(final String userName, final String targetName) {
		return dispatcher.performGet(Follow.class, Users.PATH + "/" + userName + "/follows/channels/" + targetName);
	}

	@Override
	public Result<Follow> putFollows(final String userName, final String targetName, final PutFollowsOptions options) {
		return dispatcher.performPut(Follow.class, Users.PATH + "/" + userName + "/follows/channels/" + targetName, options == null ? null : new StringEntity(options.encode(), ContentType.APPLICATION_FORM_URLENCODED));
	}

	@Override
	public Result<Void> deleteFollows(final String userName, final String targetName) {
		return dispatcher.performDelete(Void.class, Users.PATH + "/" + userName + "/follows/channels/" + targetName);
	}

	@Override
	public Result<Subscription> getSubscription(final String userName, final String channelName) {
		return dispatcher.performGet(Subscription.class, Users.PATH + "/" + userName + "/subscriptions/" + channelName);
	}
}
