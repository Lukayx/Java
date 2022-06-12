package cl.uach.info090.actividad5;

public class Libro extends Publicacion{
	public Libro(String autor, String titulo) {
		super(autor, titulo);
	}
	
	@Override
	public String toString() {
		return getTitulo()+", "+getAutor()+", "+getAgno();
	}
}
