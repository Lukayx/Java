package ArchivosParaProbarCosas;

public class Metodo {
	public static int recursivo(int n, int c) {
		if(n<=1) {
			return c;
		} else {
			return recursivo(n/2, ++c);
		}
	}
}
