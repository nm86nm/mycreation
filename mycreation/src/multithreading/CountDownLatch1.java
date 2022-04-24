package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class InstantTask implements Runnable{

	private CountDownLatch countDownLatch;	
	
	public InstantTask(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {		
		System.out.println(Thread.currentThread());
		countDownLatch.countDown();
	}	
}

class WaitTask implements Runnable{

	private CountDownLatch countDownLatch;	
	
	public WaitTask(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread());
	}	
}

public class CountDownLatch1 {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(10);
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		executorService.execute(new WaitTask(countDownLatch));
		
		for(int i=0; i<10; i++)
			executorService.execute(new InstantTask(countDownLatch));
	}
}
