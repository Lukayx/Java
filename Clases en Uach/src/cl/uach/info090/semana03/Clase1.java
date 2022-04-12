package cl.uach.info090.semana03;

public class Clase1 {
	
	public static void main(String[] args) {
		Car myCar = new Car();
		System.out.println(myCar.getLicensePlate());
		myCar.setLicensePlate("Ultima");
		System.out.println(myCar.getLicensePlate());
		myCar = new Car();
		System.out.println(myCar.getLicensePlate());
	}

}
