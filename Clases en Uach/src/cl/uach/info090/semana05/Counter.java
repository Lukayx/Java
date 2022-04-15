package cl.uach.info090.semana05;

public class Counter {
	private static int value;
	
	public static void click() {
		value++;
	}
	
	public static void reset() {
		value=0;
	}
	
	public static int getValue() {
		return value;
	}
}
