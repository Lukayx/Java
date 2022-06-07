package cl.uach.info090.recursividad;

public class Fibonacci {

	public static void main(String[] args) {
		// fibonacciLoop(15);
		
		for (int i = 1; i <= 5; i++) {
			System.out.print(fibonacciRecusion(i) + ", ");
		}

	}
	
	// Example of Fibonacci sequence without recursion
	public static void fibonacciLoop(int number) {
		int element1 = 1;
		int element2 = 1;
		
		System.out.print(element1 + ", " + element2);
		
		for (int i = 3; i <= number; i++) {
			int temp = element1 + element2; // Fibonacci number is sum of previous two Fibonacci number
			element1 = element2;
			element2 = temp;
			System.out.print(", " + temp);
		}
	}
	
	// Example of Fibonacci sequence with recursion
	public static int fibonacciRecusion(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		return fibonacciRecusion(number - 1) + fibonacciRecusion(number - 2); 
	}

}
