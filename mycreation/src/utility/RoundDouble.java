package utility;
public class RoundDouble {
	public double roundDouble(double value, int numRound){
        int tenPow = (int) Math.pow(10, numRound);
        value = value * tenPow;
        long valueRound = Math.round(value);
        value = (double)valueRound/tenPow;
                
        return value;
    }
	
	public static void main(String[] args) {
		RoundDouble roundDouble = new RoundDouble();
		System.out.println(roundDouble.roundDouble(52.3456789, 4));		
	}	
}
