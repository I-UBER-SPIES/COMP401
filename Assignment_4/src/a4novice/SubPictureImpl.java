package a4novice;

public class SubPictureImpl implements SubPicture {
	private int width;
	private int height;
	private Picture source;
	private int xOffset;
	private int yOffset;
	private Pixel[][] arrPixels;

	public SubPictureImpl(Picture source, int xOffset, int yOffset, int width, int height) {
		if (source == null) {
			throw new IllegalArgumentException();
		} else if ((xOffset + width) >= source.getWidth()) {
			throw new IllegalArgumentException();
		} else if ((yOffset + height) >= source.getHeight()) {
			throw new IllegalArgumentException();
		}
		this.width = width;
		this.height = height;
		this.source = source;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.source = source;
		

	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setPixel(int x, int y, Pixel p) {
		source.setPixel(xOffset + x, yOffset + y, p);
	}

	@Override
	public Pixel getPixel(int x, int y) {
		return source.getPixel(x + xOffset, y + yOffset);
	}

	@Override
	public int countRange(double low, double high) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void print() {

	}

	@Override
	public Picture getSource() {
		return null;
	}

	@Override
	public int getXOffset() {
		return xOffset;
	}

	@Override
	public int getYOffset() {
		return yOffset;
	}

	@Override
	public SubPicture extract(int xOffset, int yOffset, int width, int height) {
		SubPicture subPic = new SubPictureImpl(source, xOffset, yOffset, width, height);
		return subPic;
	}

}
