package Actividad3;

import java.util.ArrayList;

public class Buscaminas {
	
	public static void Campos(ArrayList<String> field,int m,int n) {
		char campo[][] = new char [m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				campo[i][j]= field.get(i).charAt(j);
				System.out.print(" "+campo[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> entrada = AccesoArchivosArrayList.leerArchivo("./data/entrada.txt");
		ArrayList<String> linea = new ArrayList<>();
		ArrayList<String> field = new ArrayList<>();
		final String numeros = "0123456789";
		int n=0,m=0,cont=0,campos=0;
		String camposStr,str = "";
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
					Campos(field, m,n);
					ingresoNumero = true;
					//linea.add(str);
					field.clear();
					cont = 0;
					str="";
				}
			}
			
		}			
		//AccesoArchivosArrayList.escribirArchivo("./data/cadenasComprimidas/salida.txt",linea); //CREA ARCHIVO DE SALIDA
	}
}