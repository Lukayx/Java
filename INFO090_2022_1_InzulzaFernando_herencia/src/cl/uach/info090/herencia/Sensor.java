package cl.uach.info090.herencia;

public class Sensor {
	private String id;
	
	public Sensor(String id) {
		this.id = id;
	}
	
	public String read() {
		return "ABC";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
