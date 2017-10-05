package module1;

public class AlgorithmControl {

	public static void main(String[] args) {
		
		// Setting up for loop to output integers from 1 to 10
		int i = 1; // initialise variable i as integer
		int maxN = 11; // initialise max value condition
		System.out.println("INTEGERS FROM 1 TO 10");
		for ( i = 1 ; i < maxN ; i=i+1) {
			System.out.println("i = "+i);
			// print integers to console
		}
		
		System.out.println();
		
		// Setting up while loop to output integers from 5 to -12
		int x = 6; // initialise integer as starting point
		System.out.println("INTEGERS FROM 5 TO -12");
		while (Math.abs(x)<12) {
			x = x-1; 
			System.out.println("x = "+x);
		}
		
		
	}

}
