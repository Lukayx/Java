package cl.uach.info090.InzulzaFernando;

public class BoletaCL extends Boleta{
	private String fecha, cliente, detalle; 
	private double neto, impuesto, valorTotal;
	
	@Override
	public String toString() {
		return fecha+" $"+valorTotal;
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
