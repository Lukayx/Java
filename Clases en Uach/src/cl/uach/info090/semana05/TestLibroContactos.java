package cl.uach.info090.semana05;

public class TestLibroContactos {

	public static void main(String[] args) {
		LibroContactos libro = new LibroContactos();
		libro.agregar(new Contacto("Daniel","7234829834"));
		libro.agregar(new Contacto("Maria","234415142"));
		libro.agregar(new Contacto("Ana","8349123"));
		libro.agregar(new Contacto("Juan","7478192"));
		
		System.out.println("Buscando a ana: "+libro.buscar("Ana"));
		System.out.println(libro.toString());
		
	}

}
