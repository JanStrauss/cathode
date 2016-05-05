package eu.over9000.cathode.data;

import java.util.List;

public class BlockList {
	private final List<Block> blocks;

	public BlockList(final List<Block> blocks) {
		this.blocks = blocks;
	}

	@Override
	public String toString() {
		return "BlockList{" +
				"blocks=" + blocks +
				'}';
	}

	public List<Block> getBlocks() {
		return blocks;
	}
}
