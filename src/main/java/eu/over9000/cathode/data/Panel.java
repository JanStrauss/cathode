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

public class Panel {

	@SerializedName("_id")
	private final long id;
	private final long displayOrder;
	private final String kind;
	private final String htmlDescription;
	private final long userId;
	private final PanelData data;
	private final String channel;

	public Panel(final long id, final long displayOrder, final String kind, final String htmlDescription, final long userId, final PanelData data, final String channel) {
		this.id = id;
		this.displayOrder = displayOrder;
		this.kind = kind;
		this.htmlDescription = htmlDescription;
		this.userId = userId;
		this.data = data;
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "Panel{" +
				"id=" + id +
				", displayOrder=" + displayOrder +
				", kind='" + kind + '\'' +
				", htmlDescription='" + htmlDescription + '\'' +
				", userId=" + userId +
				", data=" + data +
				", channel='" + channel + '\'' +
				'}';
	}

	public long getId() {
		return id;
	}

	public long getDisplayOrder() {
		return displayOrder;
	}

	public String getKind() {
		return kind;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public long getUserId() {
		return userId;
	}

	public PanelData getData() {
		return data;
	}

	public String getChannel() {
		return channel;
	}
}
