package cl.uach.info090.semana06;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person("Alex");
//		p1.setName("Ariel");
		
		Employee p2 = new Employee("Javier",1000000);
		p2.setName("Juan");
//		p2.setSalary(1000000);
//		p2.introduceMyself();
		
		System.out.println(p2); //METODO DE LA CLASE OBJECT (PARA TODAS LAS CLASES EN JAVA)
		
	}

}
