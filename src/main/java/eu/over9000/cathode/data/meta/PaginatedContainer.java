package eu.over9000.cathode.data.meta;

import java.util.List;

public interface PaginatedContainer<T> {

	long getTotal();

	List<T> getChunk();
}
