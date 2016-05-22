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

public class User {
	@SerializedName("_id")
	private final long id;
	private final String name;
	private final Date createdAt;
	private final Date updatedAt;
	private final String displayName;
	private final String logo;
	private final String bio;
	private final String type;

	public User(final long id, final String name, final Date createdAt, final Date updatedAt, final String displayName, final String logo, final String bio, final String type) {
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.displayName = displayName;
		this.logo = logo;
		this.bio = bio;
		this.type = type;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", displayName='" + displayName + '\'' +
				", logo='" + logo + '\'' +
				", bio='" + bio + '\'' +
				", type='" + type + '\'' +
				'}';
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getLogo() {
		return logo;
	}

	public String getBio() {
		return bio;
	}

	public String getType() {
		return type;
	}
}
