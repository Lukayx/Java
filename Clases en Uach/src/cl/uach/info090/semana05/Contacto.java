package cl.uach.info090.semana05;

public class Contacto {
	private String nombre;
	private String fono;
	
	public Contacto(String nombre,String fono){
		this.nombre = nombre;
		this.fono = fono;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFono() {
		return fono;
	}
	public void setFono(String fono) {
		this.fono = fono;
	}
	
	
}
