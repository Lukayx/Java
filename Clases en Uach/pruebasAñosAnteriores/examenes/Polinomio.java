package examenes;

public class Polinomio {
	public static double evaluarPolinomio(double coeficientes[], double x) {
		double sum = 0;
		for (double d : coeficientes) {
			sum += Math.pow(x, d);
		}
		return sum;
	}

//	public static double evaluarPolinomioRango(double coeficientes[], double x1, double x2, double intervalo) {
//		double sum = 0;
//		for (double d : coeficientes) {
//			sum += Math.pow(x1, d);
//		}
//		return sum;
//	}
	
	public static void main(String[] args) {
		double coeficientes[] = {2.0,-1,4.0,8};
		System.out.println("La evaluacion del polinomio segun los coeficientes es: "+ evaluarPolinomio(coeficientes, 2));
		double x1 = -1,x2 = 1;
	}
}