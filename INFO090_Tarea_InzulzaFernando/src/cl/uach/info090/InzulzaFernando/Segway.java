package cl.uach.info090.InzulzaFernando;

/**
 * <p>Segway es una clase que hereda de la Clase item
 * @author Fernando Inzulza
 */
public class Segway extends Item{
	
	public Segway(String itemId, String itemDescripcion, double valorHora, double valorBase, CreadorBoleta creadorBoleta){
		super(itemId,itemDescripcion,valorHora,valorBase,creadorBoleta);
	}
}
