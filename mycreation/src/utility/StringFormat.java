package utility;
public class StringFormat {
	public static void main(String[] args) {		
		int a = 5;
		String text = String.format("[%1$-4d]", a);	
		System.out.println(text);
	}
}