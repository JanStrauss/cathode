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
import eu.over9000.cathode.data.*;
import eu.over9000.cathode.data.parameters.Direction;
import eu.over9000.cathode.data.parameters.GetFollowsSortBy;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.PutFollowsOptions;

/**
 * <pre>
 * /user										GET				getUser();
 * /users/:user									GET				getUser(String userName);
 * /users/:user/blocks							GET				getBlocks(String userName);
 * /users/:user/blocks/:target					DELETE			deleteBlock(String userName, String targetName);
 * /users/:user/blocks/:target					PUT				putBlock(String userName, String targetName);
 * /users/:user/follows/channels				GET				getFollows(String userName, OffsetPagination pagination, Direction direction, GetFollowsSortBy sortby);
 * /users/:user/follows/channels/:target		PUT				putFollows(String userName, String targetName, PutFollowsOptions options);
 * /users/:user/follows/channels/:target		DELETE			deleteFollows(String userName, String targetName);
 * /users/:user/follows/channels/:target		GET				getFollows(String userName, String targetName);
 * /users/:user/subscriptions/:channel			GET				getSubscription(String userName, String channelName);
 * /users/:user/emotes							GET				getEmotes(String userName);
 * </pre>
 */
public interface Users {

	String PATH = "users";

	Result<User> getUser();

	Result<User> getUser(String userName);

	Result<BlockList> getBlocks(String userName);

	Result<Void> deleteBlock(String userName, String targetName);

	Result<Block> putBlock(String userName, String targetName);

	Result<FollowList> getFollows(String userName, OffsetPagination pagination, Direction direction, GetFollowsSortBy sortby);

	Result<Follow> getFollows(String userName, String targetName);

	Result<Follow> putFollows(String userName, String targetName, PutFollowsOptions options);

	Result<Void> deleteFollows(String userName, String targetName);

	Result<Subscription> getSubscription(String userName, String channelName);

	Result<EmoticonImages> getEmotes(String userName);


}
