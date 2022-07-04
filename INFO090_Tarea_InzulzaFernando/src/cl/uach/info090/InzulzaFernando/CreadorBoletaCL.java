package cl.uach.info090.InzulzaFernando;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreadorBoletaCL implements CreadorBoleta{
	private BoletaCL boleta;
	
	public Boleta generarBoleta(String cliente, String detalle, double neto) {
		//----CONSIGUIENDO LA FECHA ACTUAL EN EL FORMATO CORRECTO----
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("hh:mm");
		String fecha = detalle + "   " + dateTime.format(formatters);
		
		double impuesto = (neto*19)/100; //IVA POR REGLA DE 3 
		
		boleta = new BoletaCL(fecha,cliente,detalle,neto,impuesto,neto + impuesto);
		return boleta; 
	}

}