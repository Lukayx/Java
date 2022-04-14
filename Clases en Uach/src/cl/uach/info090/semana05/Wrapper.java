package cl.uach.info090.semana05;

import java.util.ArrayList;
import java.util.Collections;

public class Wrapper {

	public static void main(String[] args) {
		int a = 10;
		Integer b = 10;
		int c = a + Integer.parseInt("123");
		System.out.println(c+b);
		ArrayList<Integer> vector = new ArrayList<>();
		vector.add(new Integer(150));
		vector.add(30);
		vector.add(-170);
		vector.add(55);
		Collections.sort(vector);
		System.out.println(vector);
	}

}
