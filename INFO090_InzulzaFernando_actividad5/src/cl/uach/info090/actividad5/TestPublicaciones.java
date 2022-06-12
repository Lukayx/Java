package cl.uach.info090.actividad5;

public class TestPublicaciones {

	static int contarPublicados(Material[] materiales) {
		int cont = 0;
		for (Material m : materiales) {
			if(m.) cont++;
		}
		return cont;
	}

	public static void main(String[] args) {
			Libro lib = new Libro("Eduardo","Negocios");
			Revista reb = new Revista("Antonia","Como preparar Milanesa",1980);
			Material materiales[] = {lib,reb};
			System.out.println(contarPublicados(materiales));
			System.out.println(lib.estaPublicado());
	}

}
