package examenes;

public class FiltrarString {
	static String permitido = "abcdefghijklmnopqrstuvbwxyz1234567890";
	public static String fString(String text) {
		String _text = text.toLowerCase();
		String txt = "",c;
		
		for (int i = 0; i < text.length(); i++) 
		{
			c = String.valueOf(_text.charAt(i));
			if(permitido.contains(c)) {
				txt += text.charAt(i);
			}
		}
		return txt;
	}
}
