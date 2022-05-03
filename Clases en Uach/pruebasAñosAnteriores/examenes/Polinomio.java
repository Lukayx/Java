package examenes;

public class Polinomio {
	public static double evaluarPolinomio(double coeficientes[], double x) {
		double sum = 0;
		for (double d : coeficientes) {
			sum += Math.pow(x, d);
		}
		return sum;
	}

	public static double[][] evaluarPolinomioRango(double coeficientes[], double x1, double x2, double intervalo) {
		int n = (int)((x2-x1)/intervalo),j=0;
		double sum[][] = new double[n][2];
		for (double i = x1; i < x2; i+=intervalo, j++) {
			sum[j][0]=i;
			sum[j][1]=evaluarPolinomio(coeficientes, i);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		double coeficientes[] = {2.0, -1, 4.1, 8};
		System.out.println("La evaluacion del polinomio segun los coeficientes es: "+ evaluarPolinomio(coeficientes, 2));
		double x1 = -2,x2 = 4;
		double X[][] = evaluarPolinomioRango(coeficientes, x1, x2, 0.1);
		for (int i = 0; i < X.length; i++) {
			System.out.println("Punto ("+X[i][0]+" , "+X[i][1]+")");
		}
	}
}