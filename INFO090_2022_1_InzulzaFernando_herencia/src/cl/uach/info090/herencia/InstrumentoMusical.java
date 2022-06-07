package cl.uach.info090.herencia;

public class InstrumentoMusical {
	private String nSerial;
	private String material;
	
	public InstrumentoMusical(String nSerial ,String material) {
		this.nSerial = nSerial;
		this.material = material;
	}

	public String getnSerial() {
		return nSerial;
	}

	public void setnSerial(String nSerial) {
		this.nSerial = nSerial;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
}
