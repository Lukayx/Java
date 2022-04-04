package actividad2;

import java.util.ArrayList;
import java.util.Collections;

public class DiezPrimosCercanos {

	public static boolean esPrimo(int num) {
		for(int i=2; i<num;i++){
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		ArrayList<String> entrada = //ALMACENA LINEAS DEL ARCHIVO DE TEXTO EN UN ARRAY
				AccesoArchivosArrayList.leerArchivo("./data/numerosPrimos/entrada.txt");
		ArrayList<String> numPrim = new ArrayList<>(); //CONTENDRA LAS LINEAS DEL ARCHIVO DE SALIDA
		ArrayList<Integer> listaOrdenar = new ArrayList<>(); //ARRAY DE INT PARA ORDENAR Y LUEGO TRANSFORMAR A STRING
		
		for(String s : entrada) {
			String strNum = s.substring(0,s.indexOf(" "));//RECORTA EL "N" DE LA LINEA COMO STRING
			int N = Integer.parseInt(strNum);// TRANSFORMA EL "N" A INT 
			String strC = s.substring(s.indexOf(" ")+1,s.length());//RECORTA EL "P" DE LA LINEA COMO STRING
			int P = Integer.parseInt(strC);//TRANSFORMA EL "P" A INT
			
			if(N<1 || P<1 || P>10000) { //COMPRUEBA SI LOS NUMEROS ESTAN BIEN
				System.out.println("ERROR: Los numeros no cumplen con lo indicado");
				break;
			}
			//COMPROBACION DE "N"
			int c=0,i=1;
			String linea = "";
			if(esPrimo(N)) {
				c += 1;
				listaOrdenar.add(N);
			}
			//
			while(c<P){
				if((N-i)>1){
					if(esPrimo(N-i)) {
						listaOrdenar.add(N-i);
						c+=1;
					}
				}
				if(c==P) { break;}
				if(esPrimo(N+i)){
					listaOrdenar.add(N+i);
					c+=1;
				}
				i+=1;
			}
			Collections.sort(listaOrdenar);
			for(int j=0;j<listaOrdenar.size();j++){
				if(j==listaOrdenar.size()-1) {
					linea = linea + Integer.toString(listaOrdenar.get(j));
				} else {
					linea = linea + Integer.toString(listaOrdenar.get(j)) + " ";
				}
			}		
			numPrim.add(linea);
			listaOrdenar.clear();
		}
		AccesoArchivosArrayList.escribirArchivo("./data/numerosPrimos/salida.txt",numPrim); //CREARA ARCHIVO DE SALIDA
	}

}
