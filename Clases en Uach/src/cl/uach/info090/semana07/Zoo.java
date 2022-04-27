package cl.uach.info090.semana07;

import java.util.ArrayList;

public class Zoo {
	private ArrayList<Animal> animales;
	
	public Zoo() {
		animales = new ArrayList<>();
	}
	
	public void feedThemAll() {
		for (Animal a : animales) {
			a.feed();
		}
	}
	
	public void agregar(Animal a) {
		animales.add(a);
	}
	
	public ArrayList<Animal> getAnimales(){
		return animales;
	}
	
	
}
