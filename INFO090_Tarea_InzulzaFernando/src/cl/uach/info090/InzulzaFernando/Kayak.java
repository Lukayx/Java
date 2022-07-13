package cl.uach.info090.InzulzaFernando;

/**
 * <p>Kayak es una clase que hereda de la Clase item
 * @author Fernando Inzulza
 */
public class Kayak extends Item{
	
	public Kayak(String itemId, String itemDescripcion, double valorHora, double valorBase, CreadorBoleta creadorBoleta){
		super(itemId,itemDescripcion,valorHora,valorBase,creadorBoleta);
	}
}
