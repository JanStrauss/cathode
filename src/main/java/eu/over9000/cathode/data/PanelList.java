package eu.over9000.cathode.data;

import java.util.List;

public class PanelList {

	private final List<Panel> panels;

	public PanelList(final List<Panel> panels) {
		this.panels = panels;
	}

	@Override
	public String toString() {
		return "PanelList{" +
				"panels=" + panels +
				'}';
	}

	public List<Panel> getPanels() {
		return panels;
	}
}
