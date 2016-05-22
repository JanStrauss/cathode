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

public class Fps {
	private final double audioOnly;
	private final double medium;
	private final double mobile;
	private final double high;
	private final double low;
	private final double chunked;

	public Fps(final double audioOnly, final double medium, final double mobile, final double high, final double low, final double chunked) {
		this.audioOnly = audioOnly;
		this.medium = medium;
		this.mobile = mobile;
		this.high = high;
		this.low = low;
		this.chunked = chunked;
	}

	@Override
	public String toString() {
		return "Fps{" +
				"audioOnly=" + audioOnly +
				", medium=" + medium +
				", mobile=" + mobile +
				", high=" + high +
				", low=" + low +
				", chunked=" + chunked +
				'}';
	}

	public double getAudioOnly() {
		return audioOnly;
	}

	public double getMedium() {
		return medium;
	}

	public double getMobile() {
		return mobile;
	}

	public double getHigh() {
		return high;
	}

	public double getLow() {
		return low;
	}

	public double getChunked() {
		return chunked;
	}
}
