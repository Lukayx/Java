package cl.uach.info090.semana04;

public class Dice {
	private int sides;
	
	public Dice() {
		sides = 6;
	}
	
	public Dice(int sides) {
		if(sides<2) sides = 2; 
		this.sides = sides;
	}
	
	public int roll() {
		return (int)(Math.random()*sides+1);//RETORNA DOUBLE
	}
	
	public int roll(int times) {
		int sum = 0;
		if(times < 1) return 1;
		for(int i=0;i<times;i++) {
			sum+=(int)(Math.random()*sides+1);
		} 
		return sum;
		
	}
	public int getSides() {return sides;}
	
	
}
