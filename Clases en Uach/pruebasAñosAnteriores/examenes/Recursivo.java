package examenes;

public class Recursivo {
	static int metodo(int n, int c) {
		if(n<=1) {
			return c;			
		}else {
			return metodo(n/2,++c);
		}
	}
}