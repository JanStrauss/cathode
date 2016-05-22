package eu.over9000.cathode.resources.implementations;

import eu.over9000.cathode.Dispatcher;

class AbstractEndpoint {

	final Dispatcher dispatcher;

	AbstractEndpoint(final Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}
}
