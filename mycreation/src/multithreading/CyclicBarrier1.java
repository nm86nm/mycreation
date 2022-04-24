package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task1ForCyclicBarrier1 implements Runnable {
	private int counter = 0;	
	private CyclicBarrier cyclicBarrier;

	public Task1ForCyclicBarrier1(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		while (counter < 10) {
			System.out.println(Thread.currentThread() + ", counter =  " + counter);			
			counter++;		
			
			try {
				Thread.sleep(1000);
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
