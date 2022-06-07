package cl.uach.info090.herencia;

public class SensorTemperatura extends Sensor{
	
	public SensorTemperatura(String id) {
		super(id);
	}
	
	@Override
	public String read() {
		return "0 C";
	}
}