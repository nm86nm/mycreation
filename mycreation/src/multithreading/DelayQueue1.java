package multithreading;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task1ForDelayQueue1 implements Delayed, Runnable{	
	private int delay;
	
	public Task1ForDelayQueue1(int delay) {		
		this.delay = delay;
	}

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

class Consumer1ForDelayQueue1 implements Runnable{
	private DelayQueue<Task1ForDelayQueue1> delayQueue;	
	
	public Consumer1ForDelayQueue1(DelayQueue<Task1ForDelayQueue1> delayQueue) {		
		this.delayQueue = delayQueue;
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted())
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
		Random random = new Random(47);		
		
		for(int i=0; i<10; i++)
			delayQueue.put(new Task1ForDelayQueue1(random.nextInt(5000)));
		
		executorService.execute(new Consumer1ForDelayQueue1(delayQueue));
		executorService.shutdown();
	}
}
