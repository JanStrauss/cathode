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

public class Stream {

	private final long id;
	private final String game;
	private final long viewers;
	private final Date createdAt;
	private final long videoHeight;
	private final double averageFps;
	private final long delay;
	private final boolean isPlaylist;
	private final Channel channel;
	private final Image preview;

	public Stream(final long id, final String game, final long viewers, final Date createdAt, final long videoHeight, final double averageFps, final long delay, final boolean isPlaylist, final Channel channel, final Image preview) {
		this.id = id;
		this.game = game;
		this.viewers = viewers;
		this.createdAt = createdAt;
		this.videoHeight = videoHeight;
		this.averageFps = averageFps;
		this.delay = delay;
		this.isPlaylist = isPlaylist;
		this.channel = channel;
		this.preview = preview;
	}

	@Override
	public String toString() {
		return "Stream{" +
				"id=" + id +
				", game='" + game + '\'' +
				", viewers=" + viewers +
				", createdAt=" + createdAt +
				", videoHeight=" + videoHeight +
				", averageFps=" + averageFps +
				", delay=" + delay +
				", isPlaylist=" + isPlaylist +
				", channel=" + channel +
				", preview=" + preview +
				'}';
	}

	public long getId() {
		return id;
	}

	public String getGame() {
		return game;
	}

	public long getViewers() {
		return viewers;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public long getVideoHeight() {
		return videoHeight;
	}

	public double getAverageFps() {
		return averageFps;
	}

	public long getDelay() {
		return delay;
	}

	public boolean isPlaylist() {
		return isPlaylist;
	}

	public Channel getChannel() {
		return channel;
	}

	public Image getPreview() {
		return preview;
	}
}
