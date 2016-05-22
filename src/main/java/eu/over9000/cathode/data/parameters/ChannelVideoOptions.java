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

package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class ChannelVideoOptions implements Parameter {

	private Boolean broadcasts;
	private Boolean hls;

	public ChannelVideoOptions() {
	}

	public ChannelVideoOptions(final Boolean broadcasts, final Boolean hls) {
		this.broadcasts = broadcasts;
		this.hls = hls;
	}

	public boolean isBroadcasts() {
		return broadcasts;
	}

	public boolean isHls() {
		return hls;
	}

	@Override
	public List<NameValuePair> buildParamPairs() {

		final List<NameValuePair> result = new ArrayList<>();

		if (broadcasts != null) {
			result.add(new BasicNameValuePair("broadcasts", String.valueOf(broadcasts)));
		}
		if (hls != null) {
			result.add(new BasicNameValuePair("hls", String.valueOf(hls)));
		}

		return result;

	}
}
