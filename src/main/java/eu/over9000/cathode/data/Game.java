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

import com.google.gson.annotations.SerializedName;

public class Game {
	private final String name;
	private final Image box;
	private final Image logo;
	@SerializedName("_id")
	private final long id;
	private final long giantbombId;

	public Game(final String name, final Image box, final Image logo, final long id, final long giantbombId) {
		this.name = name;
		this.box = box;
		this.logo = logo;
		this.id = id;
		this.giantbombId = giantbombId;
	}


	@Override
	public String toString() {
		return "Game{" +
				"name='" + name + '\'' +
				", box=" + box +
				", logo=" + logo +
				", id=" + id +
				", giantbombId=" + giantbombId +
				'}';
	}

	public String getName() {
		return name;
	}

	public Image getBox() {
		return box;
	}

	public Image getLogo() {
		return logo;
	}

	public long getId() {
		return id;
	}

	public long getGiantbombId() {
		return giantbombId;
	}
}
