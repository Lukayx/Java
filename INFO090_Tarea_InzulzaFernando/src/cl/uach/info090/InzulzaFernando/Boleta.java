package cl.uach.info090.InzulzaFernando;

/**
 * 
 * @author Fernando Inzulza
 *
 * Clase abstracta que tiene un solo metodo, este metodo es lo minimo que necesita el objeto para ser una Boleta 
 */
public abstract class Boleta {
	private String detalle;
	
	/**
	 * @return Devuelve un String con el contenido de la boleta
	 */
	public String detalle() {
		return detalle;
	}
}
