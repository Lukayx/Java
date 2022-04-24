package examenes;

public class Profesional extends Persona{
	private String titulo;
	
	public Profesional(String name, String titulo) {
		super(name);
		this.titulo = titulo;
	}
	
	public String obtenerTitulo() {
		return titulo;
	}
	
	public void cambiarTitulo(String titulo) {
		this.titulo = titulo;
	}
}
