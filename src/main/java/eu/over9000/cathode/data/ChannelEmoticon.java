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

package eu.over9000.cathode.data;

public class ChannelEmoticon {

	private final long width;
	private final long height;
	private final String regex;
	private final String state;
	private final boolean subscriberOnly;
	private final String url;

	public ChannelEmoticon(final long width, final long height, final String regex, final String state, final boolean subscriberOnly, final String url) {
		this.width = width;
		this.height = height;
		this.regex = regex;
		this.state = state;
		this.subscriberOnly = subscriberOnly;
		this.url = url;
	}

	@Override
	public String toString() {
		return "ChannelEmoticon{" +
				"width=" + width +
				", height=" + height +
				", regex='" + regex + '\'' +
				", state='" + state + '\'' +
				", subscriberOnly=" + subscriberOnly +
				", url='" + url + '\'' +
				'}';
	}

	public long getWidth() {
		return width;
	}

	public long getHeight() {
		return height;
	}

	public String getRegex() {
		return regex;
	}

	public String getState() {
		return state;
	}

	public boolean isSubscriberOnly() {
		return subscriberOnly;
	}

	public String getUrl() {
		return url;
	}
}
