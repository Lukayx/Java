package cl.uach.info090.semana07;

public class Serpiente extends Animal{
	@Override
	public void speak() {
		int n = 3+(int)(Math.random() * 7);
		for (int i = 0; i < n; i++) {
			System.out.print("ss");
		}
		System.out.println();
	}
}