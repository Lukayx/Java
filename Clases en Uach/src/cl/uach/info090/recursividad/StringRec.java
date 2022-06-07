package cl.uach.info090.recursividad;

public class StringRec {

	public static void main(String[] args) {
		String s = append("",90);
		System.out.println(s);
	}
	
	public static String append(String r, int code){
		if(code<65) return r;
		return append(r,code-1) + Character.toString((char) code) + r;
	}

}
