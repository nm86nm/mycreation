package utility;
public class CharTable {
	public boolean checkIsLetter(char[] editText) {
        boolean letter = false;
        for(int i=0; i<editText.length; i++) {
            if(!Character.isLetter(editText[i]))
                letter = false;
            else {
                letter = true;
                break;
            }
        }
        return letter;
    }
	
	public static void main(String[] args) {
		String editTextString = "245-+*9";
		char[] editText = editTextString.toCharArray();
		CharTable charTable = new CharTable();
		boolean digitLetter = charTable.checkIsLetter(editText);
		
		if(digitLetter == true)			
		    System.out.println("In edittext is one or more letter.");
		else
			System.out.println("In edittext is not anything letter.");
			
	}	
}