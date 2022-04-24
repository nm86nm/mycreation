package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Sum implements Runnable {
	private Result result;

	public Sum(Result result) {
		this.result = result;
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			try {
				result.add();
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Difference implements Runnable {
	private Result result;

	public Difference(Result result) {
		this.result = result;
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			try {
				result.subtract();
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Result {
	int result = 0;

	public synchronized void add() throws InterruptedException {
		notifyAll();
		result++;
		System.out.println("result: " + result);
		wait();
	}

	public synchronized void subtract() throws InterruptedException {
		notifyAll();
		result--;
		System.out.println("result: " + result);
		wait();
	}
}

public class WaitNotify1 {
	public static void main(String[] args) throws InterruptedException {		
		Result result = new Result();
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new Sum(result));
		executorService.execute(new Difference(result));
		TimeUnit.SECONDS.sleep(10);
		executorService.isShutdown();
	}
}
