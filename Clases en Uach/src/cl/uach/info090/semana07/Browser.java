package cl.uach.info090.semana07;

public class Browser{
	private Connection c;
	
	public Browser(Connection c) {
		this.c = c;
	}
	
	public void loadPage(String url){
		System.out.println(c.request(url));
	}
}
