package multithreading;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

import utility.RoundDouble;

interface TaskForPriorityBlockingQueue1 extends Runnable{	
	public String getNameTask();
	public void run();
}

class Task1ForPriorityBlockingQueue1 implements TaskForPriorityBlockingQueue1, Comparable<TaskForPriorityBlockingQueue1> {	
	private final int priority;	
	
	public Task1ForPriorityBlockingQueue1(int priority) {		
		this.priority = priority;
	}	
	
	@Override
	public int compareTo(TaskForPriorityBlockingQueue1 o) {		
		return 0;
	}
	
	@Override
	public String getNameTask() {		
		return "Task1ForPriorityBlockingQueue1";
	}

	@Override
	public void run() {		
		System.out.println("This is " + getNameTask());
	}
}

class Task2ForPriorityBlockingQueue1 implements TaskForPriorityBlockingQueue1, Comparable<TaskForPriorityBlockingQueue1> {

	private final int priority;	
	
	public Task2ForPriorityBlockingQueue1(int priority) {			
		this.priority = priority;
	}
	
	@Override
	public int compareTo(TaskForPriorityBlockingQueue1 o) {		
		return 0;
	}	
	
	@Override
	public String getNameTask() {		
		return "Task2ForPriorityBlockingQueue1";
	}

	@Override
	public void run() {		
		System.out.println("This is " + getNameTask());
	}
}

class Task3ForPriorityBlockingQueue1 implements TaskForPriorityBlockingQueue1, Comparable<TaskForPriorityBlockingQueue1> {

	private final int priority;	
	
	public Task3ForPriorityBlockingQueue1(int priority) {		
		this.priority = priority;
	}	

	@Override
	public int compareTo(TaskForPriorityBlockingQueue1 o) {		 
		return 0;
	}	
	
	@Override
	public String getNameTask() {		 
		return "Task3ForPriorityBlockingQueue1";
	}

	@Override
	public void run() {		
		System.out.println("This is " + getNameTask());
	}
}

class Producer1ForPriorityBlockingQueue1 implements Runnable{	
	//private ExecutorService executorService;	
	private Queue<Runnable> queue;	

	public Producer1ForPriorityBlockingQueue1(Queue<Runnable> queue) {		
		//this.executorService = executorService;
		this.queue = queue;
	}
	
	@Override
	public void run() {		
		for(int i=0; i<10; i++) {
			queue.add(new Task1ForPriorityBlockingQueue1(1));
			int n=i+1;
			System.out.println("Task1ForPriorityBlockingQueue1 - " + n + " is added.");
		}
		
		for(int i=0; i<10; i++) {
			queue.add(new Task2ForPriorityBlockingQueue1(5));
			int n=i+1;
			System.out.println("Task2ForPriorityBlockingQueue1 - " + n + " is added.");
		}
		
		for(int i=0; i<10; i++) {
			queue.add(new Task3ForPriorityBlockingQueue1(10));
			int n=i+1;
		    System.out.println("Task3ForPriorityBlockingQueue1 - " + n + " is added.");
		}
	}
}

class Consumer1ForPriorityBlockingQueue1 implements Runnable {	
	PriorityBlockingQueue<Runnable> priorityBlockingQueue;

	public Consumer1ForPriorityBlockingQueue1(PriorityBlockingQueue<Runnable> priorityBlockingQueue) {		
		this.priorityBlockingQueue = priorityBlockingQueue;
	}

	@Override
	public void run() {
		while(!Thread.interrupted())
			try {
				priorityBlockingQueue.take().run();
			} catch (InterruptedException e) {				 
				e.printStackTrace();
			}				
	}
}

public class PriorityBlockingQueue1 {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		PriorityBlockingQueue<Runnable> priorityBlockingQueue = new PriorityBlockingQueue<Runnable>();
		executorService.execute(new Producer1ForPriorityBlockingQueue1(priorityBlockingQueue));
		Thread.sleep(1000);
		executorService.execute(new Consumer1ForPriorityBlockingQueue1(priorityBlockingQueue));		
	}
}
