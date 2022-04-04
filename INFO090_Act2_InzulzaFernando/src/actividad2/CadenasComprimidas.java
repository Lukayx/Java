package actividad2;

import java.util.ArrayList;

public class CadenasComprimidas {

	public static boolean compruebaError(String A,String B,String letra) {
		if(A.contains(letra) != true && B.contains(letra) != true) { //SI NO ESTA EN NINGUNA DE LOS 2 ENTONCES FINALIZA EL CODIGO
			return true;
		}
		return false;
	}
	
	public static byte estado(String A,String B,String letra){
		if(A.contains(letra)){ 
			return 0;
		} else { 
			return 1;
		}
	}
	public static void main(String[] args) {
		ArrayList<String> entrada = // ALMACENA LINEAS DEL ARCHIVO DE TEXTO EN UN ARRAY
				AccesoArchivosArrayList.leerArchivo("./data/cadenasComprimidas/entrada.txt");
		final String A = "1234567890", B = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String letra,num = "",str = "";
		ArrayList<String> linea = new ArrayList<>();
		byte e;
		for(String s : entrada) {
			if(s.length()>80){ // COMPRUEBA SI LA CADENA NO SUPERA EL MAXIMO DE CARACTERES
				str="ERROR";
			} else {
				letra = String.valueOf(s.charAt(0)); // RECOGE EL CARACTER EN LA POSICION INDICADA
				if(compruebaError(A,B,letra)) {break;}
				e = estado(A,B,letra);
				if(A.contains(letra)) {
					num += letra;
				} else {
					str += letra;
				}
				for(int i=1;i<s.length();i++) {
					letra = String.valueOf(s.charAt(i));
					
					if(compruebaError(A,B,letra)){break;}
					
					if(e==0 && A.contains(letra) || e==1 && A.contains(letra)) {
						num += letra;
						e = 0;
					} else if(e==0 && B.contains(letra)) {
						for(int j=0;j<Integer.parseInt(num);j++) {
							str += letra;
						}
						num = "";
					} else {
						str += letra;
					}
					e = estado(A,B,letra);
				}
				if(compruebaError(A,B,letra)) {str="ERROR";}
				linea.add(str);
				str = "";
			}
		}
			
			
		AccesoArchivosArrayList.escribirArchivo("./data/cadenasComprimidas/salida.txt",linea); //CREARA ARCHIVO DE SALIDA

	}

}
