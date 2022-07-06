package cl.uach.info090.InzulzaFernando;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreadorBoletaCL implements CreadorBoleta{
	private BoletaCL boleta;
	
	public Boleta generarBoleta(String cliente, String detalle, double neto) {
		//----CONSIGUIENDO LA FECHA ACTUAL EN EL FORMATO CORRECTO----
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy  hh:mm");
		String fecha_fin = dateTime.format(formatters);
		String fecha = detalle.substring(0,detalle.lastIndexOf(" ")) + fecha_fin.substring(fecha_fin.lastIndexOf(" "));
		double impuesto = (neto*19)/100; //IVA POR REGLA DE 3 
		
		String contenido = "------- Boleta de Arriendo --------\n";
		contenido 		+= "-----------------------------------\n";
		contenido 		+= "Boleta generada el: \n";
		contenido 		+= fecha_fin+"\n";
		contenido 		+= "-----------------------------------\n";
		contenido 		+= "Cliente: "+ cliente + "\n";
		contenido 		+= "-----------------------------------\n";
		contenido 		+= "Arriendo inicio : " + detalle.substring(0,detalle.lastIndexOf(" ")) + "\n";
		contenido 		+= "Arriendo fin    : " + fecha_fin + "\n";
		contenido 		+= "Item            : " + detalle.substring(detalle.lastIndexOf(" ")+1) + "\n";
		contenido 		+= "\n";
		contenido 		+= "neto            : " + neto + " pesos\n";
		contenido 		+= "neto + impuesto : " + (neto + impuesto) + " pesos\n";
		contenido 		+= "\n -------- Vuelva Pronto!! ---------";
		
		this.boleta = new BoletaCL(fecha,cliente,contenido,neto,impuesto,neto + impuesto);
		return boleta;
	}

}