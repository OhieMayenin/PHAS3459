package module1;

public class AlgorithmControl {
	// writing methods
	
	// writing the loop method
		public void loop() {
			// Setting up for loop to output integers from 1 to 10
			int i = 1; // initialise variable i as integer
			int maxN = 11; // initialise max value condition
			System.out.println("INTEGERS FROM 1 TO 10");
			for ( i = 1 ; i < maxN ; i=i+1) {
				System.out.println("i = "+i);
				// print integers to console
			}		
		}
		
		// writing the decrement method
		public void decrement() {
			// Setting up while loop to output integers from 5 to -12
			int x = 6; // initialise integer as starting point
			System.out.println("INTEGERS FROM 5 TO -12");
			while (Math.abs(x)<12) {
				x = x-1; 
				System.out.println("x = "+x);
			}
		}
			
		// writing the decrement method
		public void increment() {
			// Setting up while loop to print numbers 2.4 to 8.8 in steps of 0.2.
			double inc = 2.2; // initialise starting point of loop
			System.out.println("2.4 TO 8.8 IN STEPS OF 0.2");
			while (inc<8.8) {
				inc = inc + 0.2; //set increment
				System.out.printf("inc: %.1f\n",inc);
			}
		}
			
		// writing the timer method
		public void timer() {
			// Setting up while loop to run for 10 seconds
			long t = System.currentTimeMillis();   // initial time
			int loops = 0;   // initialise number of loops
			int iremainder = loops % 100;   // remainder to check if number of loops if multiple of 100; boolean condition
			// while loop prints number of loops when it is a multiple of 100
			while (iremainder == 0 ) {
				long newtime = System.currentTimeMillis();   // define current time
				while(newtime < t + 10000.) {   // limits loop to 10 seconds past initial time
					newtime = System.currentTimeMillis();   // update the time
					loops = loops + 1; // counting loops
				    System.out.println("Number of loops "+loops);
			
				}
			}
		}
				

	public static void main(String[] args) {
		AlgorithmControl ac = new AlgorithmControl(); // in order to call functions
		
		// calling all methods defined earlier
		ac.loop();
		System.out.println();
		ac.decrement();
		System.out.println();
		ac.increment();
		System.out.println();
		ac.timer();
		
		
		
		
	}

}
