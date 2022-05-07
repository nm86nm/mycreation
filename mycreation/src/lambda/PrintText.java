package lambda;

public class PrintText {
	static String welcome = "one, two, three";	
	
	public static void main(String[] args) {		
		
		PrintInterface myPrint1 = (text) -> {
			System.out.println(welcome + " " + text);
		};
		
		myPrint1.myPrint("This is a something text.");
		
		welcome = "Welcome!";
		
		myPrint1.myPrint("This is a second something text.");		
	}
}
