package multithreading;

import java.time.Duration;
import java.time.Instant;

class Operation1 {	
	public void startOperation() {		
		Instant start = Instant.now();		
		int numberOfCycle = 3;
		int maxValue = 1000000000;				
		
		for(int i=0; i<=maxValue; i++) 
			if(i==maxValue && numberOfCycle>0) {
				System.out.println("numberOfCycle = " + numberOfCycle);
				i=0;
				numberOfCycle--;				
			}		
		
		Instant end = Instant.now();		
		
		System.out.println("=======================================");		
		System.out.println("start = " + start + ", \nend   = " + end);
		System.out.println("duration = " + Duration.between(start, end).toMillis() + "ms");		
	}	
}

public class PerformanceImprovement1 {
	public static void main(String[] args) {		
			Operation1 operation1 = new Operation1();
			operation1.startOperation();			
	}
}