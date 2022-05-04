package CosasUtiles;

public class BinarioDecimal {
	static long bin2dec(String bin) {
		long decimal = 0;
		int n = bin.length();
		char c;
		final String binario = "01";
		for (int i = 0; i < bin.length(); i++) {
			c = bin.charAt(i);
			if(binario.contains(String.valueOf(c))) {
				decimal += Integer.parseInt(String.valueOf(c))*(Math.pow(2,n-1));
				n--;
			} else {
				return 0;
			}
		}
		return decimal;
	}
	
	public static void main(String[] args) {
		System.out.println("perro "+bin2dec("111111110")); 
	}
}
