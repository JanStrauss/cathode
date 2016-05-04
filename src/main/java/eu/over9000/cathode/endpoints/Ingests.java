package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Response;
import eu.over9000.cathode.data.IngestList;

/**
 * <pre>
 * /ingests                                    GET
 * </pre>
 */
public interface Ingests {

	String PATH = "ingests";

	Response<IngestList> getIngests();

}
