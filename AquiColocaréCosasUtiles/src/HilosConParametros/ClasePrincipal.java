package HilosConParametros;

public class ClasePrincipal {

	public static void main(String[] args) {
		
		Proceso hilo1 = new Proceso(" Hilo 1");
		Proceso hilo2 = new Proceso(" Hilo 2");
		Proceso hilo3 = new Proceso(" Hilo 3");
		
		hilo1.valorDeLaCondicion(5);
		hilo2.valorDeLaCondicion(8);
		hilo3.valorDeLaCondicion(7);
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}

}
