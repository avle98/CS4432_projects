package main;

public class Helper {
	public static String padZerotoInt(int number, int length) {
		return String.format("%0" + length + "d", number);
	}
	
}