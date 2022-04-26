package examenes;

import examenes.Metodos_y_prueba.Metodos;

public class TestPrueba {
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
