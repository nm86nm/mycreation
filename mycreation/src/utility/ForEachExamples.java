package utility;

import java.util.Arrays;
import java.util.List;

public class ForEachExamples {

	public void forEachExamples() {
		List<String> listStrings = Arrays.asList("Ala ", "ma ","kota.");
		
		for(String strings:listStrings) 
			System.out.print(strings);				
		System.out.print("\n");
		
		listStrings.forEach(strings->System.out.print(strings));
		System.out.print("\n");
		
		listStrings.forEach(System.out::print);		
	}
	
	public static void main(String[] args) {
		ForEachExamples os = new ForEachExamples();
		os.forEachExamples();
	}
}
