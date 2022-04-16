package ejercicios_fisica;

public class Vector {
	private double vector[] = new double[3];
	
	public Vector(double x, double y, double z) {
		 double vector[] = {x,y,z};
		 this.vector = vector;
	}
	
	public Vector(double x, double y) {
		 double vector[] = {x,y,0};
		 this.vector = vector;
	}
	
	public Vector(double vector[]) {
		 this.vector = vector;
	}
	
	public double[] getVector() {
		return vector;
	}
	public void imprimeVector() {
		System.out.println("El vector es < "+vector[0]+", "+vector[1]+", "+vector[2]+" >\n");
	}
	
	public void limpiaVector() {
		for (int i = 0; i < vector.length; i++) {
			vector[i] = 0;
		}
	}
	
	public void cambiaVector(double x, double y, double z) {
		vector[0]=x; vector[1]=y; vector[2]=z;
	}
	
	public double moduloVector() {
		double x=0;
		for (int i = 0; i < vector.length; i++) {
			x += Math.pow(vector[i], 2);
		}
		return Math.sqrt(x);
	}
	
	public void escalarPorVector(double e) {
		for (int i = 0; i < vector.length; i++) {
			vector[i]*=e;
		}
	}
	
	public void escalarDividiendoVector(double e) {
		if(e != 0){
			for (int i = 0; i < vector.length; i++) {
				vector[i]/=e;
			}
		} else System.out.println("¡ERROR! ¡NO SE PUEDE DIVIDIR POR 0!\n");
		
	}
}