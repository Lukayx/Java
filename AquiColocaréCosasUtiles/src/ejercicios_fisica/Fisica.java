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
	
}
