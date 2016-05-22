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

public class FeaturedStream {
	private final String text;

	private final String image;
	private final String title;
	private final boolean sponsored;
	private final long priority;
	private final boolean scheduled;
	private final Stream stream;

	public FeaturedStream(final String text, final String image, final String title, final boolean sponsored, final long priority, final boolean scheduled, final Stream stream) {
		this.text = text;
		this.image = image;
		this.title = title;
		this.sponsored = sponsored;
		this.priority = priority;
		this.scheduled = scheduled;
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "FeaturedStream{" +
				"text='" + text + '\'' +
				", image='" + image + '\'' +
				", title='" + title + '\'' +
				", sponsored=" + sponsored +
				", priority=" + priority +
				", scheduled=" + scheduled +
				", stream=" + stream +
				'}';
	}

	public String getText() {
		return text;
	}

	public String getImage() {
		return image;
	}

	public String getTitle() {
		return title;
	}

	public boolean isSponsored() {
		return sponsored;
	}

	public long getPriority() {
		return priority;
	}

	public boolean isScheduled() {
		return scheduled;
	}

	public Stream getStream() {
		return stream;
	}
}
