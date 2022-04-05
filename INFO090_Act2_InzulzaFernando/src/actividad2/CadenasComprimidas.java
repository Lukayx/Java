package actividad2;

import java.util.ArrayList;

public class CadenasComprimidas {

	public static boolean compruebaError(String A,String B,String letra) {
		if(A.contains(letra) != true && B.contains(letra) != true) { //SI NO ESTA EN NINGUNA DE LOS 2 ENTONCES RETORNA UN BOOLEANO
			return true;
		}
		return false;
	}
	
	public static byte estado(String A,String B,String letra){ // |1 SI ESTA EN B | 0 SI ESTA EN A |
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
			letra = String.valueOf(s.charAt(0));// SACA EL CARACTER EN LA POSICION 0 DE LA LINEA
			//SIGNIFICADO IF:| SI CASO NO ES MENOR O IGUAL A 80 |or| CARACTER NI NUMERO NI LETRA |
			if(s.length()>80 || compruebaError(A,B,letra)){ // SON CONDICIONES PARA EL *PRIMER DIGITO*
				str="ERROR";
			} else {
				e = estado(A,B,letra); // ES LETRA: e = 1 || ES NUMERO: e = 0
				if(A.contains(letra)){ // PRIMER CARACTER: SI ES NUMERO
					num += letra;
				} else { // PRIMER CARACTER: SI ES LETRA
					str += letra;
				}
				for(int i=1;i<s.length();i++) { // RECORRE CARACTERES SEGUN LA LINEA
					// SACA CARACTER SEGUN INDICE (A PARTIR DEL INDICE 1)
					letra = String.valueOf(s.charAt(i));
					if(compruebaError(A,B,letra)){// VERIFICA SI EL CARACTER ES DIFERENTE DE UN NUMERO O UNA LETRA
						str="ERROR";
						break;
					}
					if(e==0 && A.contains(letra) || e==1 && A.contains(letra)) {
						num += letra;
						e = 0;
					} else if(e==0 && B.contains(letra)) {
						// ESTO VERIFICA SI 1<num<100
						if(Integer.parseInt(num)>=100 || Integer.parseInt(num)==0) {str="ERROR"; break;} 
						//MULTIPLICA LETRAS Y LAS AGREGA A UN STRING
						for(int j=0;j<Integer.parseInt(num);j++) {
							str += letra;
						}
						num = "";//LA CANTIDAD DE VECES QUE SE REPETIA UN CARACTER SE REINICIA
					} else {
						str += letra;
					}
					e = estado(A,B,letra);
					// PARA ARREGLARLO HAZ QUE SI "E" ES 0 Y CUANDO SALE NO ES 1 PUES ESTA MALO Y SALTA ERROR 
				}
				if(e==0) { str="ERROR";	} //VERIFICA SI EL ULTIMO CARACTER DE LA LINEA ES UN NUMERO
			}
				linea.add(str);
				str = "";
				num = "";
		}			
		AccesoArchivosArrayList.escribirArchivo("./data/cadenasComprimidas/salida.txt",linea); //CREARA ARCHIVO DE SALIDA
	}
}