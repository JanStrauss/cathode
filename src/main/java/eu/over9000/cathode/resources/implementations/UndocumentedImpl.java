package eu.over9000.cathode.resources.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.PanelList;
import eu.over9000.cathode.resources.additional.Undocumented;

public class UndocumentedImpl extends AbstractEndpoint implements Undocumented {

	public UndocumentedImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<PanelList> getPanels(final String channelName) {
		return dispatcher.undocumented.getPanels(channelName);
	}
}
