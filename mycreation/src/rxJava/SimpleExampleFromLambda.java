package rxJava;

import rx.Observable;

public class SimpleExampleFromLambda {

	public static void hello(String... names) {
		Observable.from(names)
		.subscribe(s-> System.out.println("Hello " + s + "!"));
	}
	
	public static void main(String[] names) {
		hello("World", "Caterine", "Terminator");
	}
}
