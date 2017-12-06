package module8;

public class ThreadsMain {

	public static void main(String[] args) {
		CountdownTask timer = new CountdownTask(10); // set countdown from 10s
		Thread thread1 = new Thread(timer); // pass class instance to Thread constructor
				
		PrimeNumberTask primeNumberTask = new PrimeNumberTask();
		Thread thread2 = new Thread(primeNumberTask);
			
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.interrupt();
			}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		}

	}


