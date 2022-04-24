package multithreading.synchronizedExample;

public class Counter {
	volatile long count = 0;	
	
	public synchronized void add(long value) {
		this.count += value;
		System.out.print(count + ", ");
	}
}