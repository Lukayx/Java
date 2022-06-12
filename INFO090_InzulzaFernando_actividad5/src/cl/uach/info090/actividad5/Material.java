package cl.uach.info090.actividad5;

public abstract class Material {
	private String autor;
	private String titulo;
	
	public Material(String autor, String titulo) {
		this.autor = autor;
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
