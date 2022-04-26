package ArchivosParaProbarCosas;

public class MainDelRecursivo {

	public static void main(String[] args) {
		int n = 100;
		int c = 0; 
		c = Metodo.recursivo(n, c);
		System.out.println("c : "+c);
	}

}
