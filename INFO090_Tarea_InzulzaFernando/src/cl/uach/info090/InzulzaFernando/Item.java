package cl.uach.info090.InzulzaFernando;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;

public abstract class Item extends JButton implements Arrendable{	
	public String itemId, itemDescription, fechaArriendo="",cliente;
	public double valorHora, valorBase;
	private CreadorBoleta creadorBoleta;
	
	public Item(String itemId, String itemDescripcion, double valorBase, double valorHora, CreadorBoleta creadorBoleta) {
		this.itemId = itemId;
		this.itemDescription = itemDescripcion;
		this.valorBase = valorBase;
		this.valorHora = valorHora;
		this.creadorBoleta = creadorBoleta;
	}
	
	@Override
	public void arrendar(String cliente) {
		this.cliente = cliente;
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		this.fechaArriendo = dateTime.format(formatters);
	}

	@Override
	public Boleta devolver() {
		
		return creadorBoleta.generarBoleta(cliente, "asdas", valorBase);
	}

	@Override
	public boolean enArriendo() {
		if(fechaArriendo.length()==0) return false;
		return true;
	}
}
