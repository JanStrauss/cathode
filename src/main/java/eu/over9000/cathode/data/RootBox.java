package eu.over9000.cathode.data;

public class RootBox {

	private final Token token;

	public RootBox(final Token token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "RootBox{" +
				"token=" + token +
				'}';
	}

	public Token getToken() {
		return token;
	}
}
