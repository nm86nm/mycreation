package multithreading;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task1ForDelayQueue1 implements Delayed, Runnable {

	@Override
	public int compareTo(Delayed o) {
		return 0;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return 0;
	}
}

class Consumer1ForDelayQueue1 implements Runnable {
	private DelayQueue<Task1ForDelayQueue1> delayQueue;

	public Consumer1ForDelayQueue1(DelayQueue<Task1ForDelayQueue1> delayQueue) {
		this.delayQueue = delayQueue;
	}

	@Override
	public void run() {
		while (!Thread.interrupted())
			try {
				delayQueue.take().run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}

public class DelayQueue1 {
	public static void main(String[] args) {
		DelayQueue<Task1ForDelayQueue1> delayQueue = new DelayQueue<Task1ForDelayQueue1>();
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++)
			delayQueue.put(new Task1ForDelayQueue1());

		executorService.execute(new Consumer1ForDelayQueue1(delayQueue));
		executorService.shutdown();
	}
}
