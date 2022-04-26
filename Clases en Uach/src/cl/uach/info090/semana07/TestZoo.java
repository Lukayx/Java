package cl.uach.info090.semana07;

public class TestZoo {

	public static void main(String[] args) {
		Zoo z = new Zoo();
		z.agregar(new Buho());
		z.agregar(new Serpiente());
		z.agregar(new Buho());
		z.agregar(new Serpiente());
		
		
		z.feedThemAll();
		
	}

}
