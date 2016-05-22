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

import java.util.Date;

public class Subscription {

	@SerializedName("_id")
	private final String id;
	private final User user;
	private final Channel channel;
	private final Date createdAt;

	public Subscription(final String id, final Channel channel, final Date createdAt) {
		this.id = id;
		this.user = null;
		this.channel = channel;
		this.createdAt = createdAt;
	}

	public Subscription(final String id, final User user, final Date createdAt) {
		this.id = id;
		this.user = user;
		this.channel = null;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Subscription{" +
				"id='" + id + '\'' +
				", user=" + user +
				", channel=" + channel +
				", createdAt=" + createdAt +
				'}';
	}

	public String getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Channel getChannel() {
		return channel;
	}
}
