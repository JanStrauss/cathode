package eu.over9000.cathode.data.parameters;

import org.apache.http.NameValuePair;

import java.util.List;

public interface Parameter {

	List<NameValuePair> buildParamPairs();
}
