package eu.over9000.cathode.data.parameters;

public class CommercialOption {
	private enum Length {
		Length_30(30), Length_60(60), Length_90(90), Length_120(120), Length_150(150), Length_180(180);

		Length(final int value) {
			this.value = value;
		}

		private final int value;
	}

	private CommercialOption.Length length = CommercialOption.Length.Length_30;

	public CommercialOption() {
	}

	public CommercialOption(final Length length) {
		if (length != null) {
			this.length = length;
		}
	}

	public String encode() {
		return "length=" + length.value;
	}

	public Length getLength() {
		return length;
	}
}
