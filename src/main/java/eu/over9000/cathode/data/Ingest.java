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

public class Ingest {

	private final String name;
	private final double availability;
	@SerializedName("_id")
	private final long id;
	@SerializedName("default")
	private final boolean isDefault;
	private final String urlTemplate;

	public Ingest(final String name, final double availability, final long id, final boolean isDefault, final String urlTemplate) {
		this.name = name;
		this.availability = availability;
		this.id = id;
		this.isDefault = isDefault;
		this.urlTemplate = urlTemplate;
	}

	@Override
	public String toString() {
		return "Ingest{" +
				"name='" + name + '\'' +
				", availability=" + availability +
				", id=" + id +
				", isDefault=" + isDefault +
				", urlTemplate='" + urlTemplate + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public double getAvailability() {
		return availability;
	}

	public long getId() {
		return id;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public String getUrlTemplate() {
		return urlTemplate;
	}
}
