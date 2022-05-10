package paraLaPrueba;

public class Probar {

	public static void main(String[] args) {
		Cuadrado obj1 = new Cuadrado(5,2);
		Cuadrado obj2 = new Cuadrado(2,7);
		Cuadrado obj3 = new Cuadrado(12,5);
		Cuadrado obj4 = new Cuadrado(9,5);
		Cuadrado obj5 = new Cuadrado(1,1);
		Cuadrado obj6 = new Cuadrado(13,7);
		Cuadrado array[] = {obj1,obj2,obj3,obj4,obj5,obj6};
		Cuadrado.ordena(array);
		for(Cuadrado i : array) {
			System.out.println(i.area());
		}
	}
}
