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

import java.util.Optional;
import java.util.function.Consumer;

public class Result<Type> {

	private final State state;
	private final Type value;
	private final Throwable error;

	public Result(final Type value) {
		this.value = value;
		this.state = State.OK;
		this.error = null;
	}

	public Result(final Throwable error) {
		this.value = null;
		this.state = State.ERROR;
		this.error = error;
	}

	public boolean isOk() {
		return state == State.OK;
	}

	public Result<Type> ifOk(final Consumer<Type> callback) {
		if (isOk() && callback != null) {
			callback.accept(value);
		}
		return this;
	}

	public Result<Type> ifError(final Consumer<Throwable> callback) {
		if (!isOk() && callback != null) {
			callback.accept(error);
		}
		return this;
	}

	public void handle(final Consumer<Type> callbackOk, final Consumer<Throwable> callbackError) {
		ifOk(callbackOk);
		ifError(callbackError);
	}

	public void print() {
		handle(System.out::println, Throwable::printStackTrace);
	}

	public Optional<Type> asOptional() {
		return Optional.ofNullable(value);
	}

	public Type getOrException() throws Exception {
		if (isOk()) {
			return value;
		}
		throw new Exception(error);
	}

	public Type getResultRaw() {
		return value;
	}

	public Throwable getErrorRaw() {
		return error;
	}

	private enum State {OK, ERROR}

}
