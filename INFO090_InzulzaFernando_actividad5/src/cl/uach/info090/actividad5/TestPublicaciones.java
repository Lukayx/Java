package cl.uach.info090.actividad5;

public class TestPublicaciones {

	static int contarPublicados(Material[] materiales) {
		int cont = 0;
		for (Material m : materiales) {
			if(m instanceof Publicacion) {
				if(((Publicacion) m).estaPublicado()) {
					cont++;
				}
				
			}
		}
		return cont;
	}

	public static void main(String[] args) {
			Libro lib1 = new Libro("Eduardo","Negocios");
			Libro lib2 = new Libro("fernando","novelas");
			Libro lib3 = new Libro("perro","comer");
			Revista reb = new Revista("Antonia","Como preparar Milanesa",1980);
			
			Editorial panini = new Editorial("Panini");
			
			lib1.publicar(12, panini);
			reb.publicar(2014,panini);
			
			Material materiales[] = {lib1,lib2,lib3,reb};
			
			System.out.println(contarPublicados(materiales));
	}

}
