package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable {

	public void run () {
		int integer;
		int i;
		boolean isPrime = true;
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>(); // ArrayList to hold prime numbers
		int maxInt = Integer.MAX_VALUE;
		
		// loop checks if time is prime number
		while (Thread.currentThread().isInterrupted() ==false) {
			for (integer = 2; integer < maxInt; integer++) {
				isPrime = true;

				for (i = 2; i < integer; i++) {
					if (integer % i == 0) {
						isPrime = false;
						break;
						//i = integer;
					}
				}

				if (isPrime == true) {
					primeNumbers.add(integer); // add prime number to ArrayList
				}
				
			}
			
		}
		System.out.println(primeNumbers);
	}
}
