package cl.uach.info090.semana03;

	/*public class Guitar{
		String color;
		int nStrings; // si fuera "static" se aplicaría a todas las variables
		boolean hasWhammyBar;
	}*/

public class Car {
	private static String brand = "Testarossa";
	private String color;
	private String licensePlate="perro";
	private double mileage;
	
	public String getBrand(){
		return brand;
	}
	public String getColor(){
		return color;
	}	
	public String getLicensePlate(){
		return licensePlate;
	}
	public double getMileage(){
		return mileage;
	}
	public void setColor(String x) {
		color = x;
	}	
	public void setLicensePlate(String x) {
		licensePlate = x;
	}	
	public void setMileage(double x) {
		mileage = x;
	}
}	
