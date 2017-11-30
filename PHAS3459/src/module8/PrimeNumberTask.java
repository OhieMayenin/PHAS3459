package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable {
	int time; // initialise  time

	public void run () {
		int i; 
		boolean isPrime = true;
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>(); // ArrayList to hold prime numbers

		// loop checks if time is prime number
		for (i = 2; i < time; i++) {

			if (time % i == 0 && isPrime == true  ) {
				isPrime = false;
			}

		}
		if (isPrime == true) {
			primeNumbers.add(time); // add prime number to ArrayList
		}
	}
}
