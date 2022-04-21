package cl.uach.info090.semana06;

public class Employee extends Person{ //EMPLOYEE (EMPLEADO)
	private double salary;
	/*Implicit super constructor Person() is undefined for default constructor. Must define an explicit constructor 
	 * SI LA SUPER CLASE NO TIENE CONSTRUCTOR POR DEFECTO ENTONCES JAVA NO SE ATREVE A AGRAGARLE UN CONSTRUCTOR
	 * POR DEFECTO A ESTA SUBCLASE YA QUE ESTÁ MAL */

	/*public Employee() {
		super(""); LLAMANDO AL CONSTRUCTOR DE LA CLASE PERSON, SOLUCIONA EL ERROR PERO NO ES LO IDEAL PORQUE LOS
		EMPLEADOS TENDRIAN NOMBRES VACIOS
	}*/
	
	public Employee(String name, double salary) { //ESTA FORMA ES MEJOR YA QUE RELLENA MEJOR LOS DATOS DE LOS OBJETOS
		super(name);
		setSalary(salary);
	}
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	//ESTO ES SOBRECARGA (OVERLOAD); VARIOS METODOS CON EL MISMO NOMBRE PERO DIFERENTES PARAMETROS (IGUAL FUNCIONA CON CONSTRUCTORES)
	public void setSalary() { 
		setSalary(0);
	}
	
	//SOBRECARGA (OVERLOAD) RESPECTO AL METODO HEREDADO DE PERSON [DIFERENTES TIPOS DE METODOS SEGÚN LOS PARAMETROS]
	public void setName() {
		setName("");
	}
	
	// SOBRESCRITURA O REDEFINICIÓN (OVERRIDE) [REDEFINICIÓN DE METODO HEREDADO]
	public String getName() {
		return "Employee " + super.getName();
	}
	
	public String toString() {
		return super.getName();
	}
	public void introduceMyself() {
		System.out.println("Mi nombre es " + getName() + " y mi salario es " + getSalary());
	}
}
