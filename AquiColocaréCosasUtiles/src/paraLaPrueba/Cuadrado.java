package paraLaPrueba;

public class Cuadrado {
	int largo;
	int alto;
	public Cuadrado(int largo, int alto) {
		this.largo = largo;
		this.alto = alto;
	}
	
	public int getLargo() {
		return largo;
	}
	
	public void setLargo(int largo) {
		this.largo = largo;
	}
	
	public int area() {
		return largo*alto;
	}
	
	public int comparar(Cuadrado otroObjeto) {
		if(area() == otroObjeto.area()) 
			return 0;
		if(area() < otroObjeto.area()) 
			return -1;
		else
			return 1;	
	}
	
	public static Cuadrado[] ordena(Cuadrado arreglo[]) {
		if(arreglo != null){
			if(arreglo.length==0) 
				return arreglo;
			
			int j;
			Cuadrado key,aux;
			for (int i = 1; i < arreglo.length; i++) {
				key = arreglo[i];
				j = i - 1;
				while(j>=0) {
					if(arreglo[j].comparar(key) == 1) {
						aux = arreglo[j+1];
						arreglo[j+1] = arreglo[j];
						arreglo[j] = aux;
						j--;
					} else {
						break;
					}
				}
			}
			return arreglo;
		} else 
			return arreglo;
	}
}
