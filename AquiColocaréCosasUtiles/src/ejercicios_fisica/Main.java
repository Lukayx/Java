package ejercicios_fisica;

public class Main {

	public static void main(String[] args) {
		Vector v1 = new Vector(5,-3);
		v1.imprimeVector();
		Vector v2 = new Vector(6,2);
		v2.imprimeVector();
		Vector v3 = new Vector(Fisica.sumaVectores(v1, v2));
		System.out.println("La suma de ambos vectores es: ");
		v3.imprimeVector();
		Vector v4 = new Vector(Fisica.restaVectores(v1, v2));
		System.out.println("La resta de ambos vectores es: ");
		v4.imprimeVector();
		System.out.println("El producto cruz de ambos vectores es: ");
		Vector v5 = new Vector(Fisica.productoCruz(v1, v2));
		v5.imprimeVector();
		System.out.println("El producto punto de ambos vectores es: "+Fisica.productoPunto(v1, v2));
		//System.out.println("Producto punto con Modulos y Angulo entre vectores"+Fisica.productoPuntoAngulo(v1, v2,49.40));
		System.out.println("El angulo entre los vectores es: "+Fisica.anguloEntreVectores(v1, v2));
	}
}