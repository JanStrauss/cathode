package eu.over9000.cathode.data;

import java.util.Date;
import java.util.List;

public class Authorization {
	private final List<String> scopes;
	private final Date createdAt;
	private final Date updatedAt;

	public Authorization(final List<String> scopes, final Date createdAt, final Date updatedAt) {
		this.scopes = scopes;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Authorization{" +
				"scopes=" + scopes +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				'}';
	}

	public List<String> getScopes() {
		return scopes;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
}
