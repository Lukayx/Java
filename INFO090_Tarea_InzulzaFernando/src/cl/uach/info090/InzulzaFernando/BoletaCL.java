package cl.uach.info090.InzulzaFernando;

/**
 * <p>Esta clase hereda y sobreescribe los metodos de la clase Boleta además de también sobreescribir el metodo toString()
 * <p>También tiene atributos que contienen la informacion de arriendo del item
 * @author Fernando Inzulza
 */
public class BoletaCL extends Boleta{
	private String fecha, cliente, detalle; 
	private double neto, impuesto, valorTotal;
	
	/**
	 *  <p>
	 *  @return Devuelve un String con la informacion sobre el arriendo (Fecha de inicio y termino)
	 */
	@Override
	public String toString() {
		return cliente+" "+fecha+"   $"+(int)valorTotal;
	}
	
	/**
	 * @return Devuelve un String con la informacion sobre la boleta lista para exportar
	 */
	@Override
	public String detalle() {
		return detalle;
	}
	
	public BoletaCL(String fecha, String cliente, String detalle, double neto, double impuesto, double valorTotal) {
		this.fecha= fecha;
		this.cliente = cliente;
		this.detalle = detalle;
		this.neto = neto;
		this.impuesto = impuesto;
		this.valorTotal = valorTotal;
	}
}