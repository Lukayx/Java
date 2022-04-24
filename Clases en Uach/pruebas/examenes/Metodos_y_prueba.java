package examenes;

import java.util.Random;

public class Metodos_y_prueba {
	
	public class Metodos{
		public static char[] String_ArrayChar(String cadena) {
			char arreglo[] = new char[cadena.length()];
			for (int i = 0; i < arreglo.length; i++) {
				arreglo[i] = cadena.charAt(i); 
			}
			return arreglo;
		}
		
		public static String String_ArrayChar(char arreglo[]) {
			String cadena = "";
			for (int i = 0; i < arreglo.length; i++) {
				cadena += arreglo[i];
			}
			return cadena;
		}
			
		public static boolean compruebaArreglo(int arreglo[]) { // comprueba si esta ordenada de menor a mayor
			for (int i = 1; i < arreglo.length; i++) {
				if(arreglo[i-1]>arreglo[i]) return false; 
			}
			return true;
		}
		
		public static boolean compruebaRepeticion(int arreglo[]) { // comprueba si esta ordenada de menor a mayor
			for (int i = 0; i < arreglo.length-1; i++) {
				for (int j = i+1; j < arreglo.length; j++) {
					if(arreglo[i]==arreglo[j]) return false;
				}
			}
			return true;
		}
		
		public static int[] concatenarArreglos(int A1[], int A2[]) {
			int X[] = new int[A1.length+A2.length];
			int k=0,j=0;
			for (int i = 0; i < X.length; i++) {
				if(k<A1.length) {
					X[i]=A1[k];
					k++;
				} else {
					X[i]=A2[j];
					j++;
				}
			}
			return X;
		}
		
		public static String[] desordenaArreglo(String array[]) {
			int r;
			String d = "",aux;
			for (int i = 0; i < array.length; i++) {
				do {
					r = (int)(Math.random() * (array.length));
				} while (d.contains(Integer.toString(r))==true || r==i); 
				d+=r;
				aux = array[i];
				array[i] = array[r];
				array[r] = aux;
				System.out.println("indice: "+i+"     Y el random:"+r );
			}
			return array;
		}
	}

	public static void main(String[] args) {
		String cadena[] = {"Perro","Gato","Conejo","Loro","Toro","Serpiente","Leon"};
		cadena = Metodos.desordenaArreglo(cadena);
		for (int i = 0; i < cadena.length; i++) {
			System.out.println("Indice "+i+":  "+cadena[i]);
		}
	}

}
