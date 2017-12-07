/**
 * this main class runs the countdown task and prime number task
 * runs them on two different threads
 */

package module8;

public class ThreadsMain {

	public static void main(String[] args) {
		CountdownTask timer = new CountdownTask(10); // set countdown from 10s
		Thread thread1 = new Thread(timer); // pass class instance to Thread constructor
				
		PrimeNumberTask primeNumberTask = new PrimeNumberTask();
		Thread thread2 = new Thread(primeNumberTask);
		
		// starting threads
		thread1.start();
		thread2.start();
		
		try {
			thread1.join(); // wait for thread1 to complete
			thread2.interrupt(); // then interrupt thread2
			}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		}

	}


