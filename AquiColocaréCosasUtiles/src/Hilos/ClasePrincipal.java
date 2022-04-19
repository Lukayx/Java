package Hilos;

public class ClasePrincipal {

	public static void main(String[] args) {
		
		Proceso1 hilo1 = new Proceso1(); //DE ESTA FORMA SOLO TEGO QUE CREAR UN OBJETO (EXTENDS) 
		Thread hilo2 = new Thread(new Proceso2()); //SOLO CON IMPLEMENT RUNNABLE
		Proceso1 hilo3 = new Proceso1();
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}
}