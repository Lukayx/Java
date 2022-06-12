package cl.uach.info090.actividad5;

public abstract class Publicacion extends Material implements Publicable {
	private int agno;
	private Editorial editorial;
	
	public Publicacion(String autor, String titulo) {
		super(autor, titulo);
		this.agno = 0;
		this.editorial = null;
	}

	@Override
	public void publicar(int agno, Editorial editorial) {
		this.agno = agno;
		this.editorial = editorial;		
	}

	@Override
	public boolean estaPublicado() {
		if(editorial != null) return true;
		return false;
	}

	public int getAgno() {
		return agno;
	}
}
