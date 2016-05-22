package eu.over9000.cathode.resources.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.RootBox;
import eu.over9000.cathode.resources.Root;

public class RootImpl extends AbstractEndpoint implements Root {

	public RootImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<RootBox> getRoot() {
		return dispatcher.performGet(RootBox.class, Root.PATH);
	}
}
