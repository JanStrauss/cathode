package eu.over9000.cathode.data;

public class PostEmote {

	private final long id;
	private final long start;
	private final long end;
	private final long set;

	public PostEmote(final long id, final long start, final long end, final long set) {
		this.id = id;
		this.start = start;
		this.end = end;
		this.set = set;
	}

	@Override
	public String toString() {
		return "PostEmote{" +
				"id=" + id +
				", start=" + start +
				", end=" + end +
				", set=" + set +
				'}';
	}

	public long getId() {
		return id;
	}

	public long getStart() {
		return start;
	}

	public long getEnd() {
		return end;
	}

	public long getSet() {
		return set;
	}
}
