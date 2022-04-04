package actividad2;

import java.util.ArrayList;

public class CadenasComprimidas {

	public static void main(String[] args) {
		ArrayList<String> entrada = //ALMACENA LINEAS DEL ARCHIVO DE TEXTO EN UN ARRAY
				AccesoArchivosArrayList.leerArchivo("./data/cadenasComprimidas/entrada.txt");
		String a = "1234567890";
		String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(String s : entrada) {
			String str = ""; 
			if(s.length()>100 || s.length()<1) {
				System.out.println("ERROR:El archivo no cumple con lo indicado");
				System.exit(0);
			}
			
//			for(int i=0;i<s.length();i++) {
//				10A COMPROBARA EL NUMERO EN "a" Y CUANDO ENCUENTRE ALGO DE "b" ENTONCES:
//				char letra = 'A'; SACA EL CARACTER
//				int num = 10; SACA LA CANTIDAD DE VECES QUE SE AGREGARA EL CARACTER
//				for(int j = 0; j<num;j++) { HARA EL PROCESO DE AGREGAR LO ANTERIOR MENCIONADO AL STRING "str"
//					str = str + letra;
//				}
//			}
		}

	}

}
