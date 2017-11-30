package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable {
	int time;
	CountdownTask timer = new CountdownTask(time);
	

	public void run () {
		int i; 
		boolean isPrime = true;
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>(); // ArrayList to hold prime numbers

				
		// loop checks if time is prime number
		for (i = 2; i < time; i++) {

			if (timer.time % i == 0 && isPrime == true  ) {
				isPrime = false;
			}

		}
		if (isPrime == true) {
			primeNumbers.add(timer.time); // add prime number to ArrayList
		}
		
		System.out.println(primeNumbers);
	}
}
