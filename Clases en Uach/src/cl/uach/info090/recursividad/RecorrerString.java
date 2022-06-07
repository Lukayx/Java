package cl.uach.info090.recursividad;

public class RecorrerString {
	
	
	public static void main(String[] args) {
		recorre("El muelle de las almas",0);
	}
	
	public static void recorre(String input, int pos){
		System.out.print(input.charAt(pos));
		if(pos < input.length()-1)
			recorre(input,pos+1);
		
	}
}

