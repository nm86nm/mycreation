package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Task1ForSemaphore1 implements Runnable{
	private static int counter = 1;
	private final int id = counter++;
	private static Semaphore semaphore;	
	
	public Task1ForSemaphore1(int semaphoreSize) {		
		semaphore = new Semaphore(semaphoreSize);
	}

	@Override
	public void run() {
		try {			
			TimeUnit.MILLISECONDS.sleep(100*id);
			semaphore.acquire();
			System.out.println("semaphore.acruire(), id = " + id + ", semaphore.availablePermits() = " + semaphore.availablePermits());
			TimeUnit.SECONDS.sleep(5);						
			semaphore.release();			
			System.out.println("semaphore.release(), id = " + id + ", semaphore.availablePermits() = " + semaphore.availablePermits());			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
}

public class Semaphore1 {
	private static final int semaphoreSize = 5;
	
	public static void main(String[] args) {		
		ExecutorService executorService = Executors.newCachedThreadPool();		
		
		for(int i=0; i<20; i++) 			
			executorService.execute(new Task1ForSemaphore1(semaphoreSize));
	}
}
