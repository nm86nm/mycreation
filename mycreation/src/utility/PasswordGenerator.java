package utility;

import java.util.ArrayList;
import java.util.List;

public class PasswordGenerator {

	public String getPassword(int sizePassword) {
		List<Character> listChars = new ArrayList<Character>();
		Random random = new Random();
		String password = "";

		for (int i = 0; i < 10; i++) listChars.add(Integer.toString(i).charAt(0));
		for (char ch = 'a'; ch <= 'z'; ch++) listChars.add(ch);		 
		for(char ch='A'; ch<='Z'; ch++) listChars.add(ch);
		
	    for(int i=sizePassword; i>0; i--)	password += listChars.get(random.getRandomNumber(0, listChars.size()));	    

		return password;
	}

	public static void main(String[] args) {
		PasswordGenerator randomPassword = new PasswordGenerator();
		int sizePassword = 15;
		
		System.out.println(randomPassword.getPassword(sizePassword));
	}
}
