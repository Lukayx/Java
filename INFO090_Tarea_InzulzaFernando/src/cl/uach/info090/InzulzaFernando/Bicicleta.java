package cl.uach.info090.InzulzaFernando;

/**
 * <p>Bicicleta es una clase que hereda de la Clase item
 * @author Fernando Inzulza
 */
public class Bicicleta extends Item{
	
	public Bicicleta(String itemId, String itemDescripcion, double valorHora, double valorBase, CreadorBoleta creadorBoleta){
		super(itemId,itemDescripcion,valorHora,valorBase,creadorBoleta);
	}
}
