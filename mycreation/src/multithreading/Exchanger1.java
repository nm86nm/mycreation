package multithreading;

import java.util.concurrent.Exchanger;

class Task1ForExchanger1 implements Runnable{

	private Exchanger<String> exchanger;		
	
	public Task1ForExchanger1(Exchanger<String> exchanger) {		
		this.exchanger = exchanger;		
		new Thread(this).start();
	}

	@Override
	public void run() {		
		String str = "This is text from Task1";		
		
		try {
			exchanger.exchange(str);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
	}	
}

class Task2ForExchanger1 implements Runnable{

	private Exchanger<String> exchanger;		
	
	public Task2ForExchanger1(Exchanger<String> exchanger) {		
		this.exchanger = exchanger;
		new Thread(this).start();		
	}

	@Override
	public void run() {		
		try {
			String str = exchanger.exchange(new String());
			System.out.println(str);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
}

public class Exchanger1 {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();
		Task1ForExchanger1 task1ForExchanger1 = new Task1ForExchanger1(exchanger);
		Task2ForExchanger1 task2ForExchanger1 = new Task2ForExchanger1(exchanger);				
	}	
}
