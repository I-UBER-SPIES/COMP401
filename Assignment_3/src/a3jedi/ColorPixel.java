package a3jedi;

public class ColorPixel implements Pixel {
	private double _red = .5;
	private double _blue = .5;
	private double _green = .5;

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
		if (factor < 0.0 || factor > 1.0) {
			throw new RuntimeException("factor out of bounds");
		}
		Pixel p = new ColorPixel(1.0, 1.0, 1.0);
		Pixel p2 = blend(p, (1 - factor));
		return p2;
	}
	
	@Override
	public Pixel darken(double factor) {
		if (factor < 0.0 || factor > 1.0) {
			throw new RuntimeException("factor out of bounds");
		}
		Pixel p = new ColorPixel(0.0, 0.0, 0.0);
		Pixel p2 = blend(p, (1 - factor));
		return p2;
	}

	public boolean equals(Pixel p) {
		if(p == null){
			throw new RuntimeException("p is null");
		}
		double intensity = (getIntensity() > p.getIntensity()) ? getIntensity() : p.getIntensity();

		if (Math.abs(getRed() - p.getRed()) < (.1 * intensity) && Math.abs(getGreen() - p.getGreen()) < (.1 * intensity)
				&& Math.abs(getBlue() - p.getBlue()) < (.1 * intensity)) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isBetween(double value, double min, double max) {
		return ((value >= min) && (value <= max));
	}

}
