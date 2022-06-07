package cl.uach.info090.herencia;

public class BajoElectrico extends InstrumentoMusical{
	private int nCuerdas;
	
	public int getnCuerdas() {
		return nCuerdas;
	}

	public void setnCuerdas(int nCuerdas) {
		this.nCuerdas = nCuerdas;
	}

	public BajoElectrico(String nSerial, String material, int nCuerdas) {
		super(nSerial,material);
		this.nCuerdas = nCuerdas;
	}
}
