package a2jedi;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int binWidth = s.nextInt();
		int width = s.nextInt();
		int height = s.nextInt();
		int numBins = (int) Math.ceil(100.0/binWidth);
		int[] pixelIntensity = new int[width*height];
		int[] bin = new int[numBins];
		for(int i = 0; i < width*height;i++){
			pixelIntensity[i]=(s.nextInt()/binWidth);
		}
		for(int i = 0; i < pixelIntensity.length;i++){
			bin[pixelIntensity[i]]++;
		}
		int printCount = 0;
		double numPixels = height*width;

	}
	
	public static boolean isBetween(double value, double min, double max) {
		return ((value >= min) && (value <= max));
	}

}