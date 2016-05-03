package eu.over9000.cathode.endpoints.implementations;

import eu.over9000.cathode.Dispatcher;

public class AbstractEndpoint {

	protected final Dispatcher dispatcher;

	public AbstractEndpoint(final Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}
}
