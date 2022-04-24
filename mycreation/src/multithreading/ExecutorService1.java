package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExampleTask implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}	
}

public class ExecutorService1 {
	public static void main(String[] args) {
		ExecutorService executorService1 = Executors.newCachedThreadPool();	
		executorService1.execute(new ExampleTask());
		executorService1.execute(new ExampleTask());
		executorService1.shutdown();
		
		ExecutorService executorService2 = Executors.newCachedThreadPool();
		executorService2.execute(new ExampleTask());
		executorService2.shutdown();
	}
}