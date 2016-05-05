package eu.over9000.cathode;

import java.util.Optional;
import java.util.function.Consumer;

public class Result<Type> {

	private enum State {OK, ERROR}

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

	public void ifOk(final Consumer<Type> callback) {
		if (isOk() && callback != null) {
			callback.accept(value);
		}
	}

	public void ifError(final Consumer<Throwable> callback) {
		if (!isOk() && callback != null) {
			callback.accept(error);
		}
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

	public Type getResultRaw() {
		return value;
	}

	public Throwable getErrorRaw() {
		return error;
	}
}
