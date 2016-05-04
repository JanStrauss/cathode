package eu.over9000.cathode.data;

import java.util.List;

public class UserList {

	private final List<User> users;

	public UserList(final List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserList{" +
				"users=" + users +
				'}';
	}

	public List<User> getUsers() {
		return users;
	}
}
