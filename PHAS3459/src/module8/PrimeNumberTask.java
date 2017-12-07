package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable {

	public void run () {
		int integer = 2; // set starting int
		int i;
		boolean isPrime = true;
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>(); // ArrayList to hold prime numbers
		int lastInt = 0;

		// loop checks if time is prime number

		while (Thread.currentThread().isInterrupted() == false) {
			isPrime = true;
			if (integer == 2) {
				primeNumbers.add(integer);
				integer++;
				continue;
			}
			for (i = 2; i < integer; i++) {
				if (integer % i == 0) {
					isPrime = false;
					lastInt = integer;
					break;
					//i = integer;
				}
			}

			if (isPrime == true) {
				primeNumbers.add(integer); // add prime number to ArrayList
				lastInt = integer;
			}
			integer++;

		}
		//System.out.println(primeNumbers);
		int totalPrimes = primeNumbers.size();
		System.out.println("The total number of prime numbers: " +totalPrimes);
		System.out.println("The largest prime number: " + primeNumbers.get(totalPrimes-1));
		System.out.println("The largest integer checked so far: " + lastInt);

	}
}
