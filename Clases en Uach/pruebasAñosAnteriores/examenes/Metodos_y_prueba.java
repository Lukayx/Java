package examenes;

public class Metodos_y_prueba {
	
	public class Metodos{
		public static char[] String_ArrayChar(String cadena) {
			char arreglo[] = new char[cadena.length()];
			for (int i = 0; i < arreglo.length; i++) {
				arreglo[i] = cadena.charAt(i); 
			}
			return arreglo;
		}
		
		public static String ArrayChar_String(char arreglo[]) {
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
					if(arreglo[i]==arreglo[j]) return true;
				}
			}
			return false;
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
			}
			return array;
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Arreglo ordenado: ");
		String cadena[] = {"Perro","Gato","Conejo","Loro","Toro","Serpiente","Leon"};
		for (int i = 0; i < cadena.length; i++) {
			System.out.println("Indice "+i+":  "+cadena[i]);
		}
		cadena = Metodos.desordenaArreglo(cadena);
		System.out.println("Arreglo desordenado: ");
		for (int i = 0; i < cadena.length; i++) {
			System.out.println("Indice "+i+":  "+cadena[i]);
		}
		
		System.out.println("------------------------------------------");
		System.out.println("Concatena 2 arreglos: ");
		int A00[] = {5,2,67,2,8,9,2,89,6,0}, A01[] = {72,4,5,1,0};
		int X[] = Metodos.concatenarArreglos(A00, A01);
		for (int i = 0; i < X.length; i++) {
			System.out.println("Indice "+i+":  "+X[i]);
		}
		
		System.out.println("------------------------------------------");
	
		int A[] = {1,2,34,45,6,7,3,8,1,9,2};
		System.out.println("Comprueba repeticion: "+Metodos.compruebaRepeticion(A));
		
		System.out.println("------------------------------------------");
		
		int A1[] = {1,2,3,4,5,6,7,8,9};
		System.out.println("Comprueba arreglo ordenado menor a mayor: "+Metodos.compruebaArreglo(A1));
		int A2[] = {1,2,3,4,1,6,7,8,7};
		System.out.println("Comprueba arreglo no ordenado: "+Metodos.compruebaArreglo(A2));
		
		System.out.println("------------------------------------------");
		
		char B[] = {'H','o','l','a','s',' ','c','o','m','o',' ','e','s','t','a','s'};
		String txt = Metodos.ArrayChar_String(B);
		System.out.println("A partir de char[]: "+txt);
		
		System.out.println("------------------------------------------");
		
		char array[] = Metodos.String_ArrayChar(txt);
		System.out.print("A partir de String: ");
		for (char c : array) {
			System.out.print(c);
		}
		
	}

}
