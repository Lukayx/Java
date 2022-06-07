package cl.uach.info090.InzulzaFernando;

public abstract interface CreadorBoleta {
	public Boleta generarBoleta(String cliente, String detalle, double neto);
}
