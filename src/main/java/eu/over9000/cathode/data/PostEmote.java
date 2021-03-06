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

public class PostEmote {

	private final long id;
	private final long start;
	private final long end;
	private final long set;

	public PostEmote(final long id, final long start, final long end, final long set) {
		this.id = id;
		this.start = start;
		this.end = end;
		this.set = set;
	}

	@Override
	public String toString() {
		return "PostEmote{" +
				"id=" + id +
				", start=" + start +
				", end=" + end +
				", set=" + set +
				'}';
	}

	public long getId() {
		return id;
	}

	public long getStart() {
		return start;
	}

	public long getEnd() {
		return end;
	}

	public long getSet() {
		return set;
	}
}
