package actividad2;

import java.util.ArrayList;

public class CadenasComprimidas {

	public static void main(String[] args) {
		ArrayList<String> entrada = //ALMACENA LINEAS DEL ARCHIVO DE TEXTO EN UN ARRAY
				AccesoArchivosArrayList.leerArchivo("./data/cadenasComprimidas/entrada.txt");
		
		for(String s : entrada) {
			if(s.length()>100 || s.length()<1) {
				
			}
		}

	}

}
