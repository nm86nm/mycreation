package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task1ForCyclicBarrier1 implements Runnable {
	private static int counter = 0;
	private final int id = counter++;	
	
	private CyclicBarrier cyclicBarrier;	

	public Task1ForCyclicBarrier1(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;		
	}

	@Override
	public void run() {		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread() + ", id =  " + id);

			try {
				TimeUnit.SECONDS.sleep(id);
				cyclicBarrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}			
		}
	}
}

public class CyclicBarrier1 {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++)
			executorService.execute(new Task1ForCyclicBarrier1(cyclicBarrier));

		executorService.shutdown();
	}
}
