package Actividad3;

import java.util.ArrayList;

public class Buscaminas {
	
	public static ArrayList<String> Campos(ArrayList<String> field,ArrayList<String> linea,int m,int n) {
		System.out.println("perro");
		String str = "";
		char cam[][] = new char [m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(field.get(i).charAt(j)=='.') {					
					cam[i][j] = '0';
				} else {cam[i][j] = '*';}
				
				System.out.print(" "+cam[i][j]);
			}
			System.out.println();
		
		}
		if(n==1 && m==1)
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(cam[i][j] == '*') {
					if(i==0) {
						if(j==0) {
							
						}
					}
				}
			}
		}
		linea.add(str);
		return field;
	}
	
	public static void main(String[] args) {
		ArrayList<String> entrada = AccesoArchivosArrayList.leerArchivo("./data/entrada.txt");
		ArrayList<String> linea = new ArrayList<>();
		ArrayList<String> field = new ArrayList<>();
		final String numeros = "0123456789";
		int n=0,m=0,cont=0,campos=0;
		String camposStr;
		boolean ingresoNumero = true;
		for(String s : entrada) {
			if(ingresoNumero == true) {
				String strM = s.substring(0,s.indexOf(" "));
				String strN = s.substring(s.indexOf(" ")+1,s.length());
				if(numeros.contains(strM)==false || numeros.contains(strM)==false) { System.exit(0);}
				m = Integer.parseInt(strM);
				n = Integer.parseInt(strN);
				if(m > 100 || n <= 0 || n == 0 && m == 0) { System.exit(0);}
				ingresoNumero = false;
				campos++;
				camposStr = Integer.toString(campos);
				//linea.add("FIELD #"+camposStr+":");
			} else if(ingresoNumero == false) {
				field.add(s);
				cont++;
				if(cont==m) {
					field = Campos(field, linea,m,n);
					ingresoNumero = true;
					//linea.add(str);
					field.clear();
					cont = 0;
				}
			}
			
		}			
		//AccesoArchivosArrayList.escribirArchivo("./data/cadenasComprimidas/salida.txt",linea); //CREA ARCHIVO DE SALIDA
	}
}