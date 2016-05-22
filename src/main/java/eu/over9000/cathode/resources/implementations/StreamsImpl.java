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
import eu.over9000.cathode.data.FeaturedStreamList;
import eu.over9000.cathode.data.StreamBox;
import eu.over9000.cathode.data.StreamList;
import eu.over9000.cathode.data.StreamSummary;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.StreamTypeOption;
import eu.over9000.cathode.data.parameters.StreamsQuery;
import eu.over9000.cathode.resources.Streams;

public class StreamsImpl extends AbstractEndpoint implements Streams {

	public StreamsImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<StreamBox> getStream() {
		return dispatcher.performGet(StreamBox.class, Streams.PATH);
	}

	@Override
	public Result<StreamBox> getStream(final String channelName) {
		return dispatcher.performGet(StreamBox.class, Streams.PATH + "/" + channelName);
	}

	@Override
	public Result<StreamSummary> getSummary() {
		return dispatcher.performGet(StreamSummary.class, Streams.PATH + "/summary");
	}

	@Override
	public Result<FeaturedStreamList> getFeatured(final OffsetPagination pagination) {
		return dispatcher.performGet(FeaturedStreamList.class, Streams.PATH + "/featured", pagination);
	}

	@Override
	public Result<StreamList> getStreams(final StreamsQuery query, final OffsetPagination pagination) {
		return dispatcher.performGet(StreamList.class, Streams.PATH, query, pagination);
	}

	@Override
	public Result<StreamList> getFollowed(final OffsetPagination pagination, final StreamTypeOption streamType) {
		return dispatcher.performGet(StreamList.class, Streams.PATH + "/followed", pagination, streamType);
	}
}
