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

public class Team {
	@SerializedName("_id")
	private final long id;
	private final String name;
	private final String info;
	private final String displayName;
	private final Date createdAt;
	private final Date updatedAt;
	private final String logo;
	private final String banner;
	private final String background;

	public Team(final long id, final String name, final String info, final String displayName, final Date createdAt, final Date updatedAt, final String logo, final String banner, final String background) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.displayName = displayName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.logo = logo;
		this.banner = banner;
		this.background = background;
	}

	@Override
	public String toString() {
		return "Team{" +
				"id=" + id +
				", name='" + name + '\'' +
				", info='" + info + '\'' +
				", displayName='" + displayName + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", logo='" + logo + '\'' +
				", banner='" + banner + '\'' +
				", background='" + background + '\'' +
				'}';
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getInfo() {
		return info;
	}

	public String getDisplayName() {
		return displayName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getLogo() {
		return logo;
	}

	public String getBanner() {
		return banner;
	}

	public String getBackground() {
		return background;
	}
}
