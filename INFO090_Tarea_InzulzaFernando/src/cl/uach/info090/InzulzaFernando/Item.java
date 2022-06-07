package cl.uach.info090.InzulzaFernando;

import javax.swing.JButton;

public abstract class Item extends JButton implements Arrendable{	
	String itemId;
	String itemDescription;
	double valorHora;
	double valorBase;
	CreadorBoleta creadorBoleta;
	
	public Item(String itemId, String itemDescripcion, double valorHora, double valorBase, CreadorBoleta creadorBoleta) {
		this.itemId = itemId;
		this.itemDescription = itemDescripcion;
		this.valorHora = valorHora;
		this.valorBase = valorBase;
		this.creadorBoleta = creadorBoleta;
	}
	
	@Override
	public void arrendar(String cliente) {
		
	}

	@Override
	public Boleta devolver() {
		return null;
	}

	@Override
	public boolean enArriendo() {
		return false;
	}
}
