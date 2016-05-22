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

import com.google.gson.Gson;

public class ChannelOptions {
	private static final Gson gson = new Gson();

	private final String status;
	private final String game;
	private final Long deplay;
	private final Boolean channelFeedEnabled;

	public ChannelOptions(final Long deplay) {
		this.status = null;
		this.game = null;
		this.deplay = deplay;
		this.channelFeedEnabled = null;
	}

	public ChannelOptions(final Boolean channelFeedEnabled) {
		this.status = null;
		this.game = null;
		this.deplay = null;
		this.channelFeedEnabled = channelFeedEnabled;
	}

	public ChannelOptions(final String status, final String game, final Long deplay, final Boolean channelFeedEnabled) {
		this.status = status;
		this.game = game;
		this.deplay = deplay;
		this.channelFeedEnabled = channelFeedEnabled;
	}

	public ChannelOptions(final String status, final String game) {
		this.status = status;
		this.game = game;
		this.deplay = null;
		this.channelFeedEnabled = null;
	}

	public String encode() {
		return gson.toJson(new ChannelWrapper(this));
	}

	private class ChannelWrapper {
		private final ChannelOptions channel;

		public ChannelWrapper(final ChannelOptions channel) {
			this.channel = channel;
		}
	}
}
