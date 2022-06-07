package cl.uach.info090.recursividad;

public class SumaTodos {

	public static void main(String[] args) {
		System.out.println(sumaTodos(12));
		
	}
	
	public static int sumaTodos(int n){
		if (n>0){
			return n + sumaTodos(n-1);
		}else{
			return n;
		}
	}

}
