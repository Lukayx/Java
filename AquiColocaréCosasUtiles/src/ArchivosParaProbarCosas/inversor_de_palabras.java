package ArchivosParaProbarCosas;

import java.util.Scanner;

public class inversor_de_palabras {

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		System.out.print("Ingrese la frase que quiera dar vuelta: ");
		String palabra = inp.nextLine(),resultado="";
		//for(int i = 0; i < palabra.length();i++) resultado = palabra.charAt(i) + resultado; //CON FOR NORMAL
		for(int i = palabra.length();i>0;i--) resultado += palabra.charAt(i-1); //CON FOR RECORRIENDO AL REVEZ
		System.out.println("La palabra al revez es: \""+resultado+"\"");
	}

}
