package ejercicios_fisica;

public class Fisica {
	/**
	* Sumará el Primer Vector con el Segundo Vector y devolverá otro Vector 
	* @param v1 Primer Vector
	* @param v2 Segundo Vector
	* @param x True: Se redondea | False: No se redondea
	* @return double[ ]
	*/
	public static double[] sumaVectores(Vector v1, Vector v2, boolean x) {
		double V1[] = v1.getVector(), V2[] = v2.getVector() , V[] = new double[3];
		double n;
		for (int i = 0; i < 3; i++) {
			n = V1[i] + V2[i];
			if(x) n = Math.round(n*100.0)/100.0;
			V[i] = n;
		}
		return V;
	}
	
	/**
	* Restará el Primer Vector con el Segundo Vector y devolverá otro Vector 
	* @param v1 Primer Vector
	* @param v2 Segundo Vector
	* @param x True: Se redondea | False: No se redondea
	* @return double[ ]
	*/
	public static double[] restaVectores(Vector v1, Vector v2, boolean x) {
		double V1[] = v1.getVector(), V2[] = v2.getVector() , V[] = new double[3];
		double n;
		for (int i = 0; i < 3; i++) {
			n = V1[i] - V2[i];
			if(x) n = Math.round(n*100.0)/100.0;
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
	* @param x True: Se redondea | False: No se redondea
	* @return N = (x1 * x2 + y1 * y2 + z1 * z2)
	*/
	public static double productoPunto(Vector v1, Vector v2,boolean x) {
		double V1[] = v1.getVector(), V2[] = v2.getVector();
		double n=0;
		for (int i = 0; i < 3; i++) {
			n += V1[i]*V2[i];
		}
		if(x) n = Math.round(n*100.0)/100.0;
		return n;
	}
	
	/**
	* Si V1 = (X1,Y1,Z1), V2 = (X2,Y2,Z2) y Alpha entonces: 
	* 
	* 
	* 
	* @param v1 Primer Vector
	* @param v2 Segundo Vector
	* @param alpha Angulo Entre Vectores
	* @param x True: Se redondea | False: No se redondea
	* @return N = | V1 | * | V2 | * Cos(Alpha)
	*/
	public static double productoPuntoAngulo(Vector v1, Vector v2, double alpha, boolean x) {
		double n = v1.moduloVector()*v2.moduloVector()*Math.cos(alpha);
		if(x) n = Math.round(n*100.0)/100.0;
		return n;
	}
	
	/**
	* Si V1 = (X1,Y1,Z1), V2 = (X2,Y2,Z2) y Alpha entonces: 
	* 
	* 
	* 
	* @param v1 Primer Vector
	* @param v2 Segundo Vector
	* @param alpha Angulo Entre Vectores
	* @param x True: Se redondea | False: No se redondea
	* @return N = | V1 | * | V2 | * Sin(Alpha)
	*/
	public static double moduloProductoCruz(Vector v1, Vector v2, double alpha,boolean x) {
		double n = v1.moduloVector()*v2.moduloVector()*Math.sin(alpha);
		if(x) n = Math.round(n*100.0)/100.0;
		return n;
	}
	
	/**
	* Si A = (ax,ay,az), B = (bx,by,bz) entonces retornara N
 	* 
	* @param v1 Primer Vector
	* @param v2 Segundo Vector
	* @param x True: Se redondea | False: No se redondea
	* @return N = (ay*bz - by*az , -(ax*bz - bx*az) , ax*by - bx*ay)
	*/
	public static double[] productoCruz(Vector v1, Vector v2, boolean x) {
		double A[] = v1.getVector(), B[] = v2.getVector(), V[] = new double[3];
		V[0]=A[1]*B[2]-B[1]*A[2];
		V[1]=-(A[0]*B[2]-B[0]*A[2]);
		V[2]=A[0]*B[1]-B[0]*A[1];
		if(x) {
			V[0] = Math.round(V[0]*100.0)/100.0;
			V[1] = Math.round(V[1]*100.0)/100.0;
			V[2] = Math.round(V[2]*100.0)/100.0;
		}	
		return V;
	}
	
	/**
	* CosDelAngulo = (Producto punto de ambos vectores) dividido por (Modulo de ambos vectores multiplicandose)
	* Despues se saca ArcoCoseno de CosDelAngulo y después se transforma a grados *180 y /PI
	* 
 	* 
	* @param v1 Primer Vector
	* @param v2 Segundo Vector
	* @param x True: Se redondea | False: No se redondea
	* @return Angulo en grados
	*/
	public static double anguloEntreVectores(Vector v1, Vector v2,boolean x) {
		double numerador,denominador,cosDelAngulo,angulo;
		numerador = Fisica.productoPunto(v1, v2, false);
		denominador = v1.moduloVector()*v2.moduloVector();
		cosDelAngulo = numerador/denominador;
		angulo = Math.acos(cosDelAngulo)*180/Math.PI; 
		if(x) angulo = Math.round(angulo*100.0)/100.0;
		return angulo;
	}
	
	/**
	* 
	* 
 	* 
	* @param v1 Primer Vector
	* @param x True: Se redondea | False: No se redondea
	* @return Vector unitario  (double[ ])
	*/
	public static double[] encuentraVectorUnitario(Vector v1,boolean x) {
		double V1[] = v1.getVector(), moduloV1 = v1.moduloVector();
		for(int i = 0; i < V1.length; i++) {
			V1[i] /= moduloV1;
			if(x) V1[i] = Math.round(V1[i]*100.0)/100.0;
		}
		return V1;
	}
}