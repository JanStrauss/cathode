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

package eu.over9000.cathode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.BitSet;

/**
 *
 */
public class URIUtil {

	private static final BitSet safeCharacters;
	private static final char[] hexadecimal = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

	static {
		safeCharacters = new BitSet(256);
		// 'lowalpha' rule
		for (int i = 'a'; i <= 'z'; i++) {
			safeCharacters.set(i);
		}
		// 'hialpha' rule
		for (int i = 'A'; i <= 'Z'; i++) {
			safeCharacters.set(i);
		}
		// 'digit' rule
		for (int i = '0'; i <= '9'; i++) {
			safeCharacters.set(i);
		}

		// 'safe' rule
		safeCharacters.set('$');
		safeCharacters.set('-');
		safeCharacters.set('_');
		safeCharacters.set('.');
		safeCharacters.set('+');

		// 'extra' rule
		safeCharacters.set('!');
		safeCharacters.set('*');
		safeCharacters.set('\'');
		safeCharacters.set('(');
		safeCharacters.set(')');
		safeCharacters.set(',');

		// special characters
		safeCharacters.set('/');
		safeCharacters.set(':');
		safeCharacters.set('@');
		safeCharacters.set('&');
		safeCharacters.set('=');
	}

	/**
	 * Encode a path as required by the URL specification (<a href="http://www.ietf.org/rfc/rfc1738.txt">
	 * RFC 1738</a>). This differs from <code>java.net.URLEncoder.encode()</code> which encodes according
	 * to the <code>x-www-form-urlencoded</code> MIME format.
	 *
	 * @param path the path to encode
	 * @return the encoded path
	 */
	public static String encodePath(final String path) {

		final int maxBytesPerChar = 10;
		final StringBuilder rewrittenPath = new StringBuilder(path.length());
		final ByteArrayOutputStream buf = new ByteArrayOutputStream(maxBytesPerChar);
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(buf, "UTF8");
		} catch (final Exception e) {
			e.printStackTrace();
			writer = new OutputStreamWriter(buf);
		}

		for (int i = 0; i < path.length(); i++) {
			final int c = path.charAt(i);
			if (safeCharacters.get(c)) {
				rewrittenPath.append((char) c);
			} else {
				// convert to external encoding before hex conversion
				try {
					writer.write(c);
					writer.flush();
				} catch (final IOException e) {
					buf.reset();
					continue;
				}
				final byte[] ba = buf.toByteArray();
				for (final byte toEncode : ba) {
					// Converting each byte in the buffer
					rewrittenPath.append('%');
					final int low = (toEncode & 0x0f);
					final int high = ((toEncode & 0xf0) >> 4);
					rewrittenPath.append(hexadecimal[high]);
					rewrittenPath.append(hexadecimal[low]);
				}
				buf.reset();
			}
		}
		return rewrittenPath.toString();
	}


}
