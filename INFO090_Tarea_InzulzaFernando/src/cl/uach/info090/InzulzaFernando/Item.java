package cl.uach.info090.InzulzaFernando;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;

public abstract class Item extends JButton implements Arrendable{	
	private String itemId, itemDescription, fechaArriendo="";
	private double valorHora, valorBase;
	private CreadorBoleta creadorBoleta;
	
	
	
	public Item(String itemId, String itemDescripcion, double valorHora, double valorBase, CreadorBoleta creadorBoleta) {
		this.itemId = itemId;
		this.itemDescription = itemDescripcion;
		this.valorHora = valorHora;
		this.valorBase = valorBase;
		this.creadorBoleta = creadorBoleta;
	}
	
	@Override
	public void arrendar(String cliente) {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM");
		this.fechaArriendo = dateTime.format(formatters);
	}

	@Override
	public Boleta devolver() {
		return (Boleta)creadorBoleta;
	}

	@Override
	public boolean enArriendo() {
		if(fechaArriendo.length()==0) return false;
		return true;
	}
}
