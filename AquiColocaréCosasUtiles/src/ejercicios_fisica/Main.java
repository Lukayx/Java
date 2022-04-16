package ejercicios_fisica;

public class Main {

	public static void main(String[] args) {
		Vector v1 = new Vector(3.3  , 1.1, 8.5);
		v1.imprimeVector();
		Vector v2 = new Vector(5.7  , 2.7, 2.5);
		v2.imprimeVector();
		Vector v3 = new Vector(Fisica.sumaVectores(v1, v2));
		System.out.println("La suma de ambos vectores es: ");
		v3.imprimeVector();
		Vector v4 = new Vector(Fisica.restaVectores(v1, v2));
		System.out.println("La resta de ambos vectores es: ");
		v4.imprimeVector();
	}

}
