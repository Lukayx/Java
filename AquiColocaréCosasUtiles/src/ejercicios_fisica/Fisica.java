package ejercicios_fisica;

public class Fisica {
	/**
	* Sumará el Primer Vector con el Segundo Vector y devolverá otro Vector 
	* @param v1 Primer Vector
	* @param v2 Segundo Vector
	* @return double[ ]
	*/
	public static double[] sumaVectores(Vector v1, Vector v2) {
		double V1[] = v1.getVector(), V2[] = v2.getVector() , V[] = new double[3];
		double n;
		for (int i = 0; i < 3; i++) {
			n = Math.round((V1[i] + V2[i])*100.0)/100.0;
			V[i] = n;
		}
		return V;
	}
	
	/**
	* Restará el Primer Vector con el Segundo Vector y devolverá otro Vector 
	* @param v1 Primer Vector
	* @param v2 Segundo Vector
	* @return double[ ]
	*/
	public static double[] restaVectores(Vector v1, Vector v2) {
		double V1[] = v1.getVector(), V2[] = v2.getVector() , V[] = new double[3];
		double n;
		for (int i = 0; i < 3; i++) {
			n = Math.round((V1[i] - V2[i])*100.0)/100.0;
			V[i] = n;
		}
		return V;
	}
	
	/**
	* Si V1 = (x1,y1,z1) y V2 = (x2,y2,z2) entonces retornara N
	* 
	* 
	* 
	* @param v1 Primer Vector
	* @param v2 Segundo Vector
	* @return N = (x1 * x2 + y1 * y2 + z1 * z2)
	*/
	public static double productoPunto(Vector v1, Vector v2) {
		double V1[] = v1.getVector(), V2[] = v2.getVector();
		double n=0;
		for (int i = 0; i < 3; i++) {
			n += V1[i]*V2[i];
		}
		return Math.round(n*100.0)/100.0;
	}
	
	/**
	* Si V1 = (x1,y1,z1) y V2 = (x2,y2,z2) entonces retornara N
	* 
	* 
	* 
	* @param v1 Primer Vector
	* @param v2 Segundo Vector
	* @return N = (x1 * x2 + y1 * y2 + z1 * z2)
	*/
	public static double productoPuntoAngulo(Vector v1, Vector v2, double alpha) {
		double n = v1.moduloVector()*v2.moduloVector()*Math.cos(alpha);
		return Math.round(n*100.0)/100.0;
	}
	
	public static double[] productoCruz(Vector v1, Vector v2) {
		double A[] = v1.getVector(), B[] = v2.getVector(), V[] = new double[3];
		V[0]=A[1]*B[2]+B[1]*A[2];
		V[1]=-(A[0]*B[2]+B[0]*A[2]);
		V[2]=A[0]*B[1]+B[0]*A[1];
//		V[0] = Math.round(V[0]*100.0)/100.0;
//		V[1] = Math.round(V[1]*100.0)/100.0;
//		V[2] = Math.round(V[2]*100.0)/100.0;
		return V;
	}
	
	
}
