package eu.over9000.cathode.data.parameters;


public final class ImageSize {

	public static final ImageSize SMALL_PREVIEW = new ImageSize(80, 45);
	public static final ImageSize MEDIUM_PREVIEW = new ImageSize(320, 180);
	public static final ImageSize LARGE_PREVIEW = new ImageSize(640, 360);

	public static final ImageSize SMALL_GAME_BOX = new ImageSize(52, 72);
	public static final ImageSize MEDIUM_GAME_BOX = new ImageSize(136, 190);
	public static final ImageSize LARGE_GAME_BOX = new ImageSize(272, 380);

	public static final ImageSize SMALL_GAME_LOGO = new ImageSize(60, 36);
	public static final ImageSize MEDIUM_GAME_LOGO = new ImageSize(120, 72);
	public static final ImageSize LARGE_GAME_LOGO = new ImageSize(240, 144);

	public static ImageSize custom(final int width, final int height) {
		return new ImageSize(width, height);
	}

	private final int width;
	private final int height;

	private ImageSize(final int width, final int height) {
		this.width = width;
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
}
