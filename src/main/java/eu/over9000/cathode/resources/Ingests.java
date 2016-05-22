package eu.over9000.cathode.resources;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.IngestList;

/**
 * <pre>
 * /ingests                                    GET			getIngests();
 * </pre>
 */
public interface Ingests {

	String PATH = "ingests";

	Result<IngestList> getIngests();

}
