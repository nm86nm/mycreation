package rxJava;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

public class SimpleExample {

	void operationsForNumbers() {
		Observer<Calc> obs = new Observer<Calc>() {			
			@Override
			public final void onNext(Calc calc) {
				System.out.println(calc.a + "+" + calc.b + " = " + (calc.a + calc.b));
				System.out.println(calc.a + "-" + calc.b + " = " + (calc.a - calc.b));
				System.out.println(calc.a + "*" + calc.b + " = " + (calc.a * calc.b));
				System.out.println(calc.a + "/" + calc.b + " = " + (calc.a / calc.b));
				System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
			}

			@Override
			public final void onCompleted() {
				System.out.println("Finished all");
			}

			@Override
			public final void onError(Throwable e) {
				System.out.println("Error! " + e.getMessage());
			}
		};

		Calc[] calc = { new Calc(10, 2), new Calc(100, 10), new Calc(1000, 25) };
		Observable.from(calc).subscribe(obs);
	}

	static class Calc {
		int a;
		int b;

		Calc(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static void hello(String... names) {
		Observable.from(names).subscribe(new Action1<String>() {
			@Override
			public void call(String s) {
				System.out.println("Hello " + s + "!");
			}
		});
	}

	public static void main(String[] args) {
		hello("World", "Veronica", "John", "Ala");
		System.out.println("*********************");
		SimpleExample sE = new SimpleExample();
		sE.operationsForNumbers();
	}
}
