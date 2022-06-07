package cl.uach.info090.recursividad;


// From https://www.tutorialspoint.com/javaexamples/method_tower.htm
public class TowerOfHanoi {
	public static void main(String[] args) {
		int nDisks = 20;
		doTowers(nDisks, 'A', 'B', 'C');
	}
	
	public static void doTowers(int topN, char from, char inter, char to) {
		if (topN == 1){
			System.out.println("Disk 1 from " + from + " to " + to);
		}else {
			doTowers(topN - 1, from, to, inter);
			System.out.println("Disk " + topN + " from " + from + " to " + to);
			doTowers(topN - 1, inter, from, to);
		}
	}
}
