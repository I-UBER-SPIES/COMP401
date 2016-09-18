package a3adept;

public class ColorPixel implements Pixel {
	private double _red;
	private double _blue;
	private double _green;

	public ColorPixel(double red, double green, double blue) {
		if (red < 0.0 || red > 1.0) {
			throw new RuntimeException("All pixel values must be between 0 and 1");
		} else if (green < 0.0 || green > 1.0) {
			throw new RuntimeException("All pixel values must be between 0 and 1");
		} else if (blue < 0.0 || blue > 1.0) {
			throw new RuntimeException("All pixel values must be between 0 and 1");
		}
		_red = red;
		_blue = blue;
		_green = green;
	}

	@Override
	public double getRed() {
		return _red;
	}

	@Override
	public double getGreen() {
		return _green;
	}

	@Override
	public double getBlue() {
		return _blue;
	}

	@Override
	public double getIntensity() {
		double intensity = (.299 * getRed()) + (.587 * getGreen()) + (.114 * getBlue());
		return intensity;
	}

	@Override
	public char getChar() {
		double i = getIntensity();
		char charPix = 'E';
		if (isBetween(i, 0.0, 0.1)) {
			charPix = '#';
		} else if (isBetween(i, .1, .2)) {
			charPix = 'M';
		} else if (isBetween(i, .2, .3)) {
			charPix = 'X';
		} else if (isBetween(i, .3, .4)) {
			charPix = 'D';
		} else if (isBetween(i, .4, .5)) {
			charPix = '<';
		} else if (isBetween(i, .5, .6)) {
			charPix = '>';
		} else if (isBetween(i, .6, .7)) {
			charPix = 's';
		} else if (isBetween(i, .7, .8)) {
			charPix = ':';
		} else if (isBetween(i, .8, .9)) {
			charPix = '-';
		} else if (isBetween(i, .9, 1) || i == 0) {
			charPix = ' ';
		}
		return charPix;
	}

	@Override
	public Pixel blend(Pixel p, double weight) {
		if (weight < 0 || weight > 1) {
			throw new RuntimeException("weight out of limits, 0-1");
		} else if (p == null) {
			throw new RuntimeException("pixel parameter is null");
		}
		double red = (getRed() * weight) + (p.getRed() * (1 - weight));
		double green = (getGreen() * weight) + (p.getGreen() * (1 - weight));
		double blue = (getBlue() * weight) + (p.getBlue() * (1 - weight));
		Pixel p2 = new ColorPixel(red, green, blue);
		return p2;
	}

	@Override
	public Pixel lighten(double factor) {
		Pixel p = new ColorPixel(getRed(), getGreen(), getBlue());
		Pixel p2 = blend(p, factor);
		if (factor < 0.0 || factor > 1.0) {
			throw new RuntimeException("factor out of bounds");
		}
		double red = ;
		double green = (p2.getGreen()/getGreen());
		double blue = (p2.getBlue()/getBlue());
		Pixel p3 = new ColorPixel(red, green, blue);
		return p3;
	}

	public Pixel darken(double factor) {
		Pixel p = new ColorPixel(getRed(), getGreen(), getBlue());
		Pixel p2 = blend(p, (1-factor));
		if (factor < 0.0 || factor > 1.0) {
			throw new RuntimeException("factor out of bounds");
		}
		double red = p2.getRed();
		double green = p2.getGreen();
		double blue = p2.getBlue();
		Pixel p3 = new ColorPixel(red, green, blue);
		return p3;
	}
	
	public boolean equals(Pixel p){
		Pixel p2 = new ColorPixel(getRed(),getGreen(),getBlue());
		return true;
	}

	public static boolean isBetween(double value, double min, double max) {
		return ((value >= min) && (value <= max));
	}

}
