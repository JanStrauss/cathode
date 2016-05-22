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
import eu.over9000.cathode.data.parameters.*;

/**
 * <pre>
 * /channel                                    GET			getChannel()
 * /channels/:channel                          GET			getChannel(String channelName)
 * /channels/:channel                          PUT			putChannel(String channelName, ChannelOptions options);
 * /channels/:channel/commercial               POST			postCommercial(CommercialOption options);
 * /channels/:channel/editors                  GET			getEditors(String channelName);
 * /channels/:channel/follows                  GET			getFollows(String channelName, CursorPagination pagination)
 * /channels/:channel/stream_key               DELETE		deleteStreamKey();
 * /channels/:channel/subscriptions            GET			getSubscriptions(String channelName, OffsetPagination pagination, Direction direction);
 * /channels/:channel/subscriptions/:user      GET			getSubscription(String channelName, String userName);
 * /channels/:channel/teams                    GET			getUsers(String channelName)
 * /channels/:channel/videos                   GET			getVideos(String channelName, OffsetPagination pagination, ChannelVideoOptions options)
 * </pre>
 */
public interface Channels {

	String PATH = "channels";

	Result<Channel> getChannel();

	Result<Channel> getChannel(String channelName);

	Result<FollowList> getFollows(String channelName, CursorPagination pagination, Direction direction);

	Result<TeamList> getTeams(String channelName);

	Result<VideoList> getVideos(String channelName, OffsetPagination pagination, ChannelVideoOptions options);

	Result<UserList> getEditors(String channelName);

	Result<SubscriptionList> getSubscriptions(String channelName, OffsetPagination pagination, Direction direction);

	Result<Subscription> getSubscription(String channelName, String userName);

	Result<Channel> deleteStreamKey(String channelName);

	Result<Void> postCommercial(String channelName, CommercialOption options);

	Result<Channel> putChannel(String channelName, ChannelOptions options);


}