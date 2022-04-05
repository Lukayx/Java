package cl.uach.info090.semana04;

public class Dice {
	private int sides = 6;
	
	public Dice(int sides) {
		this.sides = sides;
	}
	
	public int roll() {
		return (int)(Math.random()*sides+1);//RETORNA DOUBLE
	}
	public int getSides() {return sides;}
	
	
}
