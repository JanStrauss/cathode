package eu.over9000.cathode;

import java.util.Optional;
import java.util.function.Consumer;

public class Response<Type> {


	private enum State {SUCCESS, FAILED}

	private final State state;
	private final Type result;
	private final Throwable error;

	public Response(final Type result) {
		this.result = result;
		this.state = State.SUCCESS;
		this.error = null;
	}

	public Response(final Throwable error) {
		this.result = null;
		this.state = State.FAILED;
		this.error = error;
	}

	public boolean isSuccess() {
		return state == State.SUCCESS;
	}

	public void ifSuccess(final Consumer<Type> callback) {
		if (isSuccess() && callback != null) {
			callback.accept(result);
		}
	}

	public void ifFailed(final Consumer<Throwable> callback) {
		if (!isSuccess() && callback != null) {
			callback.accept(error);
		}
	}

	public void handle(final Consumer<Type> callbackSuccess, final Consumer<Throwable> callbackFailed) {
		ifSuccess(callbackSuccess);
		ifFailed(callbackFailed);
	}

	public Optional<Type> asOptional() {
		return Optional.ofNullable(result);
	}

	public Type getResultRaw() {
		return result;
	}


	public Throwable getErrorRaw() {
		return error;
	}
}
