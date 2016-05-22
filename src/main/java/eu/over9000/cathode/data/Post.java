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

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Post {
	private final String id;
	private final Date createdAt;
	private final boolean deleted;
	private final List<PostEmote> emotes;
	private final Map<String, PostReaction> reactions;
	private final String body;
	private final User user;

	public Post(final String id, final Date createdAt, final boolean deleted, final List<PostEmote> emotes, final Map<String, PostReaction> reactions, final String body, final User user) {
		this.id = id;
		this.createdAt = createdAt;
		this.deleted = deleted;
		this.emotes = emotes;
		this.reactions = reactions;
		this.body = body;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post{" +
				"id='" + id + '\'' +
				", createdAt=" + createdAt +
				", deleted=" + deleted +
				", emotes=" + emotes +
				", reactions=" + reactions +
				", body='" + body + '\'' +
				", user=" + user +
				'}';
	}

	public String getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public List<PostEmote> getEmotes() {
		return emotes;
	}

	public Map<String, PostReaction> getReactions() {
		return reactions;
	}

	public String getBody() {
		return body;
	}

	public User getUser() {
		return user;
	}
}
