package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class InstantTask implements Runnable{
	private static int counter = 1;
	private final int id = counter++;
	private CountDownLatch countDownLatch;	
	
	public InstantTask(CountDownLatch countDownLatch) {		
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {		
		try {
			TimeUnit.SECONDS.sleep(id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("InstantTask -> " + Thread.currentThread());
		countDownLatch.countDown();
	}
}

class WaitTask implements Runnable{	
	private CountDownLatch countDownLatch;	
	
	public WaitTask(CountDownLatch countDownLatch) {		
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("WaitTask -> " + Thread.currentThread());
	}	
}

public class CountDownLatch1 {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(10);
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for(int i=0; i<10; i++)
			executorService.execute(new WaitTask(countDownLatch));
		
		for(int i=0; i<10; i++)
			executorService.execute(new InstantTask(countDownLatch));		
		
		executorService.shutdown();
	}
}
