package multithreading;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutor1 {
	private int digit = 1;	
	ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
	
	public void schedule(Runnable event, long delay) {
		scheduledThreadPoolExecutor.schedule(event, delay, TimeUnit.MILLISECONDS);
	}
	
	public void repeat(Runnable event, long initialDelay, long period) {
		scheduledThreadPoolExecutor.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MILLISECONDS);
	}
	
	class Addition implements Runnable {
		@Override
		public void run() {
			digit += digit;
			System.out.println("(addition) digit = " + digit);
		}		
	}
	
	class Subtraction implements Runnable {
		@Override
		public void run() {
			digit -= digit;
			System.out.println("(subtraction) digit =  " + digit);
			
		}		
	}
	
	class Multiplication implements Runnable {
		@Override
		public void run() {
			digit *= digit;	
			System.out.println("(multiplication) digit = " + digit);
		}		
	}
	
	class Division implements Runnable {
		@Override
		public void run() {
			digit /= digit;
			System.out.println("(division) digit = " + digit);			
		}
	}
	
	class Terminate implements Runnable {
		@Override
		public void run() {
			System.out.println("==========");
			System.out.println("| Terminating! |");
			System.out.println("==========");
			System.out.println("(summary) digit = " + digit);
			scheduledThreadPoolExecutor.shutdownNow();			
		}	
	}
	
	public static void main(String[] args) {
	    ScheduledThreadPoolExecutor1 scheduledThreadPoolExecutor1 = new ScheduledThreadPoolExecutor1();	    
	    scheduledThreadPoolExecutor1.schedule(scheduledThreadPoolExecutor1.new Terminate(), 5000);
	    scheduledThreadPoolExecutor1.repeat(scheduledThreadPoolExecutor1.new Addition(), 0, 200);
	    scheduledThreadPoolExecutor1.repeat(scheduledThreadPoolExecutor1.new Subtraction(), 4000, 1000);
	    scheduledThreadPoolExecutor1.repeat(scheduledThreadPoolExecutor1.new Multiplication(), 0, 100);
	    scheduledThreadPoolExecutor1.repeat(scheduledThreadPoolExecutor1.new Division(), 300, 300);		
	}
}
