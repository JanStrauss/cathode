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
import eu.over9000.cathode.data.ChannelList;
import eu.over9000.cathode.data.GameList;
import eu.over9000.cathode.data.StreamList;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.SearchChannelOptions;
import eu.over9000.cathode.data.parameters.SearchGamesOptions;
import eu.over9000.cathode.data.parameters.SearchStreamsOptions;
import eu.over9000.cathode.resources.Search;

public class SearchImpl extends AbstractEndpoint implements Search {

	public SearchImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<ChannelList> getChannels(final SearchChannelOptions options, final OffsetPagination pagination) {
		return dispatcher.performGet(ChannelList.class, Search.PATH + "/channels", options, pagination);
	}

	@Override
	public Result<GameList> getGames(final SearchGamesOptions options) {
		return dispatcher.performGet(GameList.class, Search.PATH + "/games", options);
	}

	@Override
	public Result<StreamList> getStreams(final SearchStreamsOptions options, final OffsetPagination pagination) {
		return dispatcher.performGet(StreamList.class, Search.PATH + "/streams", options, pagination);
	}
}
