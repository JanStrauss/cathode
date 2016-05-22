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

package eu.over9000.cathode.data.parameters;


public final class ImageSize {

	public static final ImageSize SMALL_PREVIEW = new ImageSize(80, 45);
	public static final ImageSize MEDIUM_PREVIEW = new ImageSize(320, 180);
	public static final ImageSize LARGE_PREVIEW = new ImageSize(640, 360);

	public static final ImageSize SMALL_GAME_BOX = new ImageSize(52, 72);
	public static final ImageSize MEDIUM_GAME_BOX = new ImageSize(136, 190);
	public static final ImageSize LARGE_GAME_BOX = new ImageSize(272, 380);

	public static final ImageSize SMALL_GAME_LOGO = new ImageSize(60, 36);
	public static final ImageSize MEDIUM_GAME_LOGO = new ImageSize(120, 72);
	public static final ImageSize LARGE_GAME_LOGO = new ImageSize(240, 144);
	private final int width;
	private final int height;
	private ImageSize(final int width, final int height) {
		this.width = width;
		this.height = height;
	}

	public static ImageSize custom(final int width, final int height) {
		return new ImageSize(width, height);
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
}
