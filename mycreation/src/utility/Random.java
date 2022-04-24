package utility;
public class Random {	
	public static void main(String[] args) {
		java.util.Random random = new java.util.Random(20);	
		int number = random.nextInt(200);
		System.out.println("random number is: " + number);
		
		int mathrandom = (int) (Math.random() * 100);
		System.out.println("Math.random() = " + mathrandom);
	}
}