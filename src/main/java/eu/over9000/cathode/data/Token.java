package eu.over9000.cathode.data;

public class Token {
	private final boolean valid;
	private final String userName;
	private final Authorization authorization;

	public Token(final boolean valid, final String userName, final Authorization authorization) {
		this.valid = valid;
		this.userName = userName;
		this.authorization = authorization;
	}

	@Override
	public String toString() {
		return "Token{" +
				"valid=" + valid +
				", userName='" + userName + '\'' +
				", authorization=" + authorization +
				'}';
	}

	public boolean isValid() {
		return valid;
	}

	public String getUserName() {
		return userName;
	}

	public Authorization getAuthorization() {
		return authorization;
	}
}
