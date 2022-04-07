package cl.uach.info090.semana03;

	/*public class Guitar{
		String color;
		int nStrings; // si fuera "static" se aplicaría a todas las variables
		boolean hasWhammyBar;
	}*/

public class Car {
	private double tankCapacity = 100;
	private double milesPerGallon = 15;
	private double miles = 0.0;
	private double gas = 0.0;
	
	public Car(double tankCapacity, double milesPerGallon) {
		if(milesPerGallon >0)
			this.milesPerGallon = milesPerGallon;
		else
			this.milesPerGallon = 15;
		
		if(tankCapacity > 0)
			this.tankCapacity = tankCapacity;
		else 
			this.tankCapacity = 20;
		
		gas = 0.0;
		miles = 0.0;
		
	}

	
	public void putGas(double gallons) {
		gas += gallons;
		if(gas>tankCapacity)gas=tankCapacity;
		if(gas < 0);
	}
	public void drive(double miles) {
		this.miles = miles;
		if(miles < 0) return;
		if(miles > gas*tankCapacity) {
				gas=0;
				this.miles += gas*tankCapacity;
		} else {
			this.miles += miles;
			gas -= miles/tankCapacity;
		}
	}

	public double getGas() {return gas;}
	public double getMiles() {return miles;	}
	/*
	private static String brand = "Testarossa";
	private String color;
	private String licensePlate;
	private double mileage;
	*/
	
	/*
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
	*/
}	
