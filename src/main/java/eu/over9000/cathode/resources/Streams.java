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
import eu.over9000.cathode.data.FeaturedStreamList;
import eu.over9000.cathode.data.StreamBox;
import eu.over9000.cathode.data.StreamList;
import eu.over9000.cathode.data.StreamSummary;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.StreamTypeOption;
import eu.over9000.cathode.data.parameters.StreamsQuery;

/**
 * <pre>
 * /streams                                    GET			getStream();
 * /streams/:channel/                          GET			getStream(String channelName);
 * /streams/featured                           GET			getFeatured(OffsetPagination pagination);
 * /streams/followed                           GET			getFollowed();
 * /streams/summary                            GET			getSummary();
 * </pre>
 */
public interface Streams {

	String PATH = "streams";

	//	-GET 	/streams 				Get stream object
	Result<StreamBox> getStream();

	//	-GET 	/streams/:channel/ 		Get stream object
	Result<StreamBox> getStream(String channelName);

	//	-GET 	/streams/summary 		Get a summary of streams
	Result<StreamSummary> getSummary();

	//	-GET 	/streams/featured 		Get a list of featured streams
	Result<FeaturedStreamList> getFeatured(OffsetPagination pagination);

	Result<StreamList> getStreams(StreamsQuery query, OffsetPagination pagination);

	//	-GET 	/streams/followed 		Get a list of streams user is following
	Result<StreamList> getFollowed(OffsetPagination pagination, StreamTypeOption type);

}