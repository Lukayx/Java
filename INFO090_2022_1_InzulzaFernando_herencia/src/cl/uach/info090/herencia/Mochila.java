package cl.uach.info090.herencia;

public class Mochila extends Bolso{
	private boolean impermeable;
	
	public Mochila(double capacidad, boolean impermeable) {
		super(capacidad);
		this.impermeable = impermeable;
	}

	public boolean isImpermeable() {
		return impermeable;
	}

	public void setImpermeable(boolean impermeable) {
		this.impermeable = impermeable;
	}
}