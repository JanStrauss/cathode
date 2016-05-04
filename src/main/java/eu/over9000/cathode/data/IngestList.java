package eu.over9000.cathode.data;

import java.util.List;

/**
 * Created by Jan on 04.05.2016.
 */
public class IngestList {

	private final List<Ingest> ingests;

	public IngestList(final List<Ingest> ingests) {
		this.ingests = ingests;
	}

	@Override
	public String toString() {
		return "IngestList{" +
				"ingests=" + ingests +
				'}';
	}

	public List<Ingest> getIngests() {
		return ingests;
	}
}
