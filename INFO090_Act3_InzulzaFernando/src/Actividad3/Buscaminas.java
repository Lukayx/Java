package Actividad3;

import java.util.ArrayList;

public class Buscaminas {
	
	public static void main(String[] args) {
		ArrayList<String> entrada = AccesoArchivosArrayList.leerArchivo("./data/entrada.txt");
		ArrayList<String> linea = new ArrayList<>();
		ArrayList<String> field = new ArrayList<>();
		final String numeros = "0123456789";
		int n=0,m=0,cont=0,campos=0;
		String camposStr;
		Campo N;
		boolean ingresoNumero = true;
		for(String s : entrada) {
			if(ingresoNumero == true) {
				String strM = s.substring(0,s.indexOf(" "));
				String strN = s.substring(s.indexOf(" ")+1,s.length());
				if(numeros.contains(strM)==false || numeros.contains(strM)==false) { System.exit(0);}
				m = Integer.parseInt(strM);
				n = Integer.parseInt(strN);
				if(m > 100 || m < 0 || n < 0 || n>100) { System.exit(0);} 
				if(n == 0 && m == 0) {
					AccesoArchivosArrayList.escribirArchivo("./data/salida.txt",linea);//CREA ARCHIVO DE SALIDA
					System.exit(0);
				}
				ingresoNumero = false;
				campos++;
				camposStr = Integer.toString(campos);
				linea.add("FIELD #"+camposStr+":");
			} else if(ingresoNumero == false) {
				field.add(s);
				cont++;
				if(cont==m) {
					N = new Campo(field,m,n);
					linea.add(N.campoListo());
					ingresoNumero = true;
					field.clear();
					cont = 0;
				}
			}
			
		}			
		
	}
}