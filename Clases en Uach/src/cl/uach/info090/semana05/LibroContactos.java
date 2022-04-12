package cl.uach.info090.semana05;

import java.util.ArrayList;

public class LibroContactos {
	private ArrayList<Contacto> contactos;
	
	public LibroContactos(){
		contactos = new ArrayList<>();
	}
	
	public void agregar(Contacto contacto){
		contactos.add(contacto);
	}
	
	public Contacto buscar(String nombre) {
		for(Contacto i : contactos) {
			if(i.getNombre().equalsIgnoreCase(nombre)) {
				return i;
			}
		}
		return null;
	}
	
	public ArrayList<Contacto> getContactos() {
		return contactos;
	}
}