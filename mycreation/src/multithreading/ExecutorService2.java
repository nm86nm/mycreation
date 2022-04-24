package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RandomNumber implements Runnable {
	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			double randomNumber = Math.random() * 100;
			int roundNumber = (int) Math.round(randomNumber);
			System.out.println(Thread.currentThread().getName() + ": random number = " + roundNumber);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}
}

public class ExecutorService2 {
	public static void main(String[] args) {
		RandomNumber randomNumber = new RandomNumber();
		
		ExecutorService cachedPool = Executors.newCachedThreadPool();
		ExecutorService fixedPool = Executors.newFixedThreadPool(3);
		ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 5; i++) {
			cachedPool.execute(randomNumber);
			fixedPool.execute(randomNumber);
			singleExecutor.execute(randomNumber);
		}		
		cachedPool.shutdown();
		fixedPool.shutdown();
		singleExecutor.shutdown();		
	}
}
