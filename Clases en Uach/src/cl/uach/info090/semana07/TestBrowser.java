package cl.uach.info090.semana07;

public class TestBrowser {

	public static void main(String[] args) {
//		Browser obj = new Browser(new Connection()); SALDRÁ ERROR YA QUE NO SE PUEDEN CREAR OBJETOS DE UNA CLASE ABSTRACTA
		Browser obj = new Browser(new ConnectionWifi());
		obj.loadPage("blablabla");
	}
}
