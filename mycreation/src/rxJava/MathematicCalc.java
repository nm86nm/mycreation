package rxJava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MathematicCalc {
	
	static class Calc{		
		double startAmount;
		double rate;		
		double period;
		String note;
		
		public Calc(double startAmount, double rate, double period, String note) {			
			this.startAmount = startAmount;
			this.rate = rate;
			this.period = period;
			this.note = note;
		}		
	}
	
	public void rateOfReturnInTime(Calc[] calc) {		
		utility.RoundDouble roundDouble = new utility.RoundDouble();
		
		
		Observer<Calc> observer = new Observer<Calc>(){			

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void onNext(Calc calc) {
				double result = calc.startAmount * Math.pow((calc.rate * 0.01 + 1),  calc.period);
				result = roundDouble.roundDouble(result, 2);
				System.out.println(calc.startAmount + " * " +  "(" + calc.rate + "%" + " + " +  1 + ")^" + calc.period  + " = " + result + " (" + calc.note + ")");				
			}

			@Override
			public void onError(Throwable e) {
				System.err.println(e.getMessage());				
			}

			@Override
			public void onComplete() {
				System.out.println("All operations has been completed.");				
			}
			
		};
		
		//Calc[] calc = {new Calc(startAmount, rateOfReturn, period)};
		Observable.fromArray(calc).subscribe(observer);
	}
	
	public double getRate(double startAmount, double result) {
		utility.RoundDouble roundDouble = new utility.RoundDouble();
		double rate = roundDouble.roundDouble((result - startAmount)/startAmount * 100, 2);
		
		return rate;
	}
	
	public double getValue(double startAmount, double result) {
		utility.RoundDouble roundDouble = new utility.RoundDouble();
		double value = roundDouble.roundDouble(result - startAmount, 2);
		
		return value;
	}

	public static void main(String[] args) {		
		MathematicCalc mathematicCalc = new MathematicCalc();
		utility.RoundDouble roundDouble = new utility.RoundDouble();		
	
		double startAmount = 30;
		double amount = 40;
		double rate = mathematicCalc.getRate(startAmount, amount);
//		double rate = -5;
		double value = mathematicCalc.getValue(startAmount, amount);		
		
		Calc[] calc = {new Calc(startAmount, rate, 1,"day") 
				,new Calc(startAmount, rate, 5, "week") 
				,new Calc(startAmount, rate, 10, "two weeks")
				,new Calc(startAmount, rate, 15, "three weeks")
				,new Calc(startAmount, rate, 20, "mounth") 
//				,new Calc(startAmount, rate, 20*5, "2019.04.25")
//				,new Calc(startAmount, rate, 20*6, "half year")
//				,new Calc(startAmount, rate, 20*9, "nine month")
//				,new Calc(startAmount, rate, 20*12, "year")
				};
				
		
		System.out.println("This is a MathematicCalc.class");								
		
		if(rate > 0) {
			System.out.println("Daily rate of return is: " + rate + "%");
			System.out.println("Daily profit is: " + value);		
		}
		else {
			System.out.println("Daily rate of loss is: " + rate + "%");
			System.out.println("Daily loss is: " + value);
		}
		
		mathematicCalc.rateOfReturnInTime(calc);		
	}
}