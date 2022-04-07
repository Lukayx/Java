package cl.uach.info090.semana04;

public class DiceTest {

	public static void main(String[] args) {
		Dice d = new Dice(3);
		for(int i = 0; i<1000;i++) {
			int v = d.roll(2);
			System.out.print(v+"  ");
			if(i%11==0) System.out.println();
			if(v>(d.getSides()) || v<1) System.out.println("Error!");
		}
	}

}
