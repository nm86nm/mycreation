package utility;

public class Random {
	
	public int getRandomNumber(int min, int max) {
		RoundDouble roundDouble = new RoundDouble();		
		double randomNumberDouble = Math.random() * (max - min) + min;		
		int randomNumberInt = (int) roundDouble.roundDouble(randomNumberDouble, 0);		

		return randomNumberInt;
	}

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println(random.getRandomNumber(0, 10));
	}
}