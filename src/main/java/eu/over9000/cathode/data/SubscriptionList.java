package eu.over9000.cathode.data;

import com.google.gson.annotations.SerializedName;
import eu.over9000.cathode.data.meta.PaginatedContainer;

import java.util.List;

public class SubscriptionList implements PaginatedContainer<Subscription> {

	@SerializedName("_total")
	private final long total;
	private final List<Subscription> subscriptions;

	public SubscriptionList(final long total, final List<Subscription> subscriptions) {
		this.total = total;
		this.subscriptions = subscriptions;
	}

	@Override
	public String toString() {
		return "SubscriptionList{" +
				"total=" + total +
				", subscriptions=" + subscriptions +
				'}';
	}

	public long getTotal() {
		return total;
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	@Override
	public List<Subscription> getChunk() {
		return subscriptions;
	}

	@Override
	public String getCursor() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return subscriptions.isEmpty();
	}
}
