package aasdasdasdasd;

public class MatrizEnergetica {
	private PlantaEnergetica planta[];
	public MatrizEnergetica(PlantaEnergetica planta[]){
		this.planta = planta;
	}
	
	public double totalMw() {
		double suma = 0;
		for (PlantaEnergetica c : planta) {
			suma += c.getMw();
		}
		return suma;
	}
	
	public double mwLimpios() {
		double suma = 0;
		for (PlantaEnergetica c : planta) {
			if(c instanceof EnergiaLimpia) {
				suma += c.getMw();
			}
		}
		return suma;
	}
	
	public double bonosCarbono() {
		double suma = 0;
		for (PlantaEnergetica c : planta) {
			if(c instanceof EnergiaLimpia) {
				suma += ((EnergiaLimpia) c).bonosCarbono();
			}
		}
		return suma;
	}
}
