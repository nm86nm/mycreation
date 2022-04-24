package multithreading;

class ExecuteThread4 implements Runnable{
	@Override
	public void run() {
		System.out.println("thread4");		
	}	
}

class ExecuteThread3 extends Thread{
	@Override
	public void run() {
		System.out.println("thread3");
	}	
}

public class ThreadRunnable1 {
	public void executeThread2() {
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread2");
			}
		});
		
		thread2.start();
		System.out.println(thread2.getName());
	}

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread1");
			}
		});
		
		thread1.start();
		System.out.println(thread1.getName());		
		
		ThreadRunnable1 training1 = new ThreadRunnable1();
		training1.executeThread2();		
		
		ExecuteThread3 executeThread3 = new ExecuteThread3();
		executeThread3.start();
		System.out.println(executeThread3.getName());
		
		Thread thread4 = new Thread(new ExecuteThread4());
		thread4.start();
		System.out.println(thread4.getName());
	}
}