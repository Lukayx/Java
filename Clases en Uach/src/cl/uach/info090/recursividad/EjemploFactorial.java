package cl.uach.info090.recursividad;

public class EjemploFactorial {

	public static void main(String[] args) {
		System.out.println(factorial(5));

	}
	
	public static int factorial(int n){
		if(n==1) 
			return 1; // el caso base
		else 
			return n*factorial(n-1); // el caso recursivo
	}
}

// factoria(5)