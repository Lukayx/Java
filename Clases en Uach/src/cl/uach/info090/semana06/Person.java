package cl.uach.info090.semana06;

public class Person {
	protected String name; /*PROTECTED TE PERMITE ACCEDER A LA VARIABLE COMO SI FUERA PUBLICA SOLO CON LAS SUBCLASES DE PERSON,
	TODAS LAS DEMAS CLASES EXTERNAS DEBEN USAR LOS METODOS DE ESTA CLASE PARA ACCEDER A �L (COMO SI FUERA PRIVADA)*/
	public String getName() {
		return name;
	}
	public Person(String name) { //ESTE CONSTRUCTOR SE TRANSFIERE A LAS SUBCLASES DE IGUAL FORMA
		setName(name);
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override /*SE USA PARA AVISAR QUE SE SOBRESCRIBIR� UN METODO HEREDADO DE LA CLASE OBJECT 
	(SI EST� MAL ESCRITO ENTONCES TE LO DICE, DE ESTA FORMA TE AYUDA A SABER SI TE EQUIVOCASTE AL ESCRIBIR)*/
	public String toString() {
		return getName();
	}
}