package cl.uach.info090.InzulzaFernando;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;

public abstract class Item extends JButton implements Arrendable{	
	private String itemId, itemDescription, fechaArriendo="",cliente="";
	private double valorHora, valorBase;
	private CreadorBoleta creadorBoleta;
	
	public Item(String itemId, String itemDescripcion, double valorBase, double valorHora, CreadorBoleta creadorBoleta) {
		this.itemId = itemId;
		this.itemDescription = itemDescripcion;
		this.valorBase = valorBase;
		this.valorHora = valorHora;
		this.creadorBoleta = creadorBoleta;
	}
	
	/**
	 * Recibe el nombre del cliente y calcula la fecha actual junto con la hora, luego almacena ambos datos en cliente y fechaArriendo respectivamente.
	 * <p>
	 * Si el largo del String es 0 entonces el cliente y la fechaArriendo se establecerán en "".
	 * 
	 * @param cliente Nombre del cliente que esta arrendando el item
	 */
	@Override
	public void arrendar(String cliente) {
		if(cliente.length()!=0) {			
			this.cliente = cliente;
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
			this.fechaArriendo = dateTime.format(formatters);
		} else {
			this.cliente="";
			this.fechaArriendo="";
		}
	}

	/**
	 * @return Devuelve un objeto tipo Boleta que tiene todos los datos correspondientes al arriendo.
	 */
	@Override
	public Boleta devolver() {
		//----CONSIGUIENDO LA FECHA ACTUAL EN EL FORMATO CORRECTO----
				LocalDateTime dateTime = LocalDateTime.now();
				DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
				String fecha_fin = dateTime.format(formatters);
				
				String horaInicio = this.fechaArriendo.substring(this.fechaArriendo.indexOf(":")-2);
				String horaTermino = fecha_fin.substring(fecha_fin.indexOf(":")-2);
				
				String fecha =this.fechaArriendo + horaTermino;
				
				int segIni = Integer.parseInt(horaInicio.substring(0,2))*60 + Integer.parseInt(horaInicio.substring(3));
				int segFin = Integer.parseInt(horaTermino.substring(0,2))*60 + Integer.parseInt(horaTermino.substring(3));
				
				int horasTotales = segFin - segIni;
				if(horasTotales<0) horasTotales *= -1;
				horasTotales /= 60;
				
				double neto = valorBase + valorHora*(horasTotales);
				
				String detalle = this.fechaArriendo+"(1)"+fecha_fin+"(2)"+this.itemId;
				
		return creadorBoleta.generarBoleta(cliente, detalle, neto);	
	}

	/**
	 * Este metodo permite conocer el estado actual en el que se encuentra el item.
	 * 
	 * @return Retornara 'false' si no esta arrendado, 'true' si lo está.
	 */
	@Override
	public boolean enArriendo() {
		if(fechaArriendo.length()==0) return false;
		return true;
	}
	
	public String getItemId() {
		return itemId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public String getFechaArriendo() {
		return fechaArriendo;
	}

	public String getCliente() {
		return cliente;
	}

	public double getValorHora() {
		return valorHora;
	}

	public double getValorBase() {
		return valorBase;
	}

}
