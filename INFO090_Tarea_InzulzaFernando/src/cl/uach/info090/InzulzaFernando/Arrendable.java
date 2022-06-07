package cl.uach.info090.InzulzaFernando;

public abstract interface Arrendable {
	public void arrendar(String cliente);
	public Boleta devolver();
	public boolean enArriendo();
}
