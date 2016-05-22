package eu.over9000.cathode.resources.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.IngestList;
import eu.over9000.cathode.resources.Ingests;

public class IngestsImpl extends AbstractEndpoint implements Ingests {

	public IngestsImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<IngestList> getIngests() {
		return dispatcher.performGet(IngestList.class, Ingests.PATH);
	}
}
