package eu.over9000.cathode.endpoints.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.RootBox;
import eu.over9000.cathode.data.Token;
import eu.over9000.cathode.endpoints.Root;

/**
 * Created by Jan on 05.05.2016.
 */
public class RootImpl extends AbstractEndpoint implements Root {

	public RootImpl(Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<RootBox> getRoot() {
		return dispatcher.getAPIResponse(RootBox.class, Root.PATH);
	}
}
