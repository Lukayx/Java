package aasdasdasdasd;

public class main {

	public static void main(String[] args) {
		PlantaEnergetica a[] = {new PlantaCarbon(10), new PlantaEolica(20, false), new PlantaSolar(40, false)};
		MatrizEnergetica asd = new MatrizEnergetica(a);
		System.out.println("total " +asd.totalMw());
		System.out.println("limpio "+ asd.mwLimpios());
		System.out.println("carbon "+asd.bonosCarbono());
	}

}
