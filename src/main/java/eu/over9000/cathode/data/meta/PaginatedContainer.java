package eu.over9000.cathode.data.meta;

import eu.over9000.cathode.data.parameters.Pagination;

import java.util.List;

public interface PaginatedContainer<T> {

	long getTotal();

	String getCursor();

	List<T> getChunk();

	Pagination.PaginationType getPaginationType();

	boolean isEmpty();
}
