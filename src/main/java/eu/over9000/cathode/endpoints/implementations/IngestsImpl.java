package eu.over9000.cathode.endpoints.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.IngestList;
import eu.over9000.cathode.endpoints.Ingests;

/**
 * Created by Jan on 04.05.2016.
 */
public class IngestsImpl extends AbstractEndpoint implements Ingests {

	public IngestsImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<IngestList> getIngests() {
		return dispatcher.getAPIResponse(IngestList.class, Ingests.PATH);
	}
}
