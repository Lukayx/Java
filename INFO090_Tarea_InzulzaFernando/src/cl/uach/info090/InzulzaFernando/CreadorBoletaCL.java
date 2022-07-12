package cl.uach.info090.InzulzaFernando;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreadorBoletaCL implements CreadorBoleta{
	private BoletaCL boleta;
	
	/**
	 * Este metodo creará un objeto Boleta que tendrá el contenido de lo que será exportado, ademas de los datos correspondientes al arriendo como atributos.
	 * 
	 */
	public Boleta generarBoleta(String cliente, String detalle, double neto) {
		double impuesto = (neto*19)/100; //IVA POR REGLA DE 3 
		
		String fechaInicio= detalle.substring(0,detalle.indexOf("(1)"));
		String fechaFin= detalle.substring(detalle.indexOf("(1)")+3,detalle.indexOf("(2)"));
		String itemId= detalle.substring(detalle.indexOf("(2)")+3);
		
		String contenido = "------- Boleta de Arriendo --------\n";
		contenido 		+= "-----------------------------------\n";
		contenido 		+= "Boleta generada el: \n";
		contenido 		+=  fechaFin+"\n";
		contenido 		+= "-----------------------------------\n";
		contenido 		+= "Cliente: "+ cliente + "\n";
		contenido 		+= "-----------------------------------\n";
		contenido 		+= "Arriendo inicio : " + fechaInicio + "\n";
		contenido 		+= "Arriendo fin    : " + fechaFin + "\n";
		contenido 		+= "Item            : " + itemId + "\n";
		contenido 		+= "\n";
		contenido 		+= "neto            : " + (int)neto + " pesos\n";
		contenido 		+= "neto + impuesto : " + (int)(neto + impuesto) + " pesos\n";
		contenido 		+= "\n -------- Vuelva Pronto!! ---------";
		
		this.boleta = new BoletaCL(fechaInicio + " " + fechaFin.substring(fechaFin.indexOf(":")-2),cliente,contenido,neto,impuesto,neto + impuesto);
		return boleta;
	}
	
}