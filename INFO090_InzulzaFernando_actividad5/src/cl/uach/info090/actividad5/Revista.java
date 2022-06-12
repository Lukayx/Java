package cl.uach.info090.actividad5;

public class Revista extends Publicacion{
	private int numero;
	public Revista(String autor, String titulo,  int numero) {
		super(autor, titulo);
		this.numero = numero;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return getTitulo()+", "+getAutor()+", "+getAgno()+", "+getNumero();
	}
}
