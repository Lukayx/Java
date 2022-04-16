package ejercicios_fisica;

public class Main {

	public static void main(String[] args) {
		System.out.print("VECTOR 1: ");
		Vector v1 = new Vector(5,-3);
		v1.imprimeVector();
		System.out.println("EL MODULO DEL VECTOR 1 ES: "+v1.moduloVector()+"\n");
		
		Vector v2 = new Vector(6,2);
		System.out.print("VECTOR 2: ");
		v2.imprimeVector();
		System.out.println("EL MODULO DEL VECTOR 2 ES: "+v2.moduloVector()+"\n");
		
		Vector sumaVector1Y2 = new Vector(Fisica.sumaVectores(v1, v2, true));
		System.out.print("SUMA VECTOR 1 Y 2: ");
		sumaVector1Y2.imprimeVector();
		
		Vector restaVector1Y2 = new Vector(Fisica.restaVectores(v1, v2, false));
		System.out.print("RESTA VECTOR 1 Y 2: ");
		restaVector1Y2.imprimeVector();
		
		Vector unitarioV1 = new Vector(Fisica.encuentraVectorUnitario(v1, true));
		System.out.print("VECTOR UNITARIO DE V1: ");
		unitarioV1.imprimeVector();
		
		Vector unitarioV2 = new Vector(Fisica.encuentraVectorUnitario(v2, true));
		System.out.print("VECTOR UNITARIO DE V2: ");
		unitarioV2.imprimeVector();
		
		v2.escalarDividiendoVector(0);
		
		System.out.println("PRODUCTO PUNTO VECTOR 1 Y 2: "+Fisica.productoPunto(v1, v2, false)+"\n");
		
		double alpha = Fisica.anguloEntreVectores(v1, v2, false);
		System.out.println("EL ANGULO ENTRE LOS VECTORES 1 Y 2 ES: "+alpha+"\n");
		
		Vector productoCruzV1YV2 = new Vector(Fisica.productoCruz(v1, v2, false));
		System.out.print("PRODUCTO CRUZ VECTOR 1 Y 2: ");
		productoCruzV1YV2.imprimeVector();
		
		System.out.println("EL MODULO DEL PRODUCTO CRUZ ENTRE EL VECTOR 1 Y 2: "+Fisica.moduloProductoCruz(v1,v2,alpha,true)+"\n");				
	}
}