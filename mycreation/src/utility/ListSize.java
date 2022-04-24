package utility;
import java.util.ArrayList;
import java.util.List;

public class ListSize {

	public static void main(String[] args) {
		List<Integer> listInteger = new ArrayList<Integer>(); 
		for(int i=15; i<=27; i++)
			listInteger.add(i);
		
		System.out.println(listInteger.size());
		for(int i=0; i<listInteger.size(); i++)
			System.out.print(listInteger.get(i) + ", ");
	}
}
