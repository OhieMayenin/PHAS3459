// This class is to write void methods, and also to write a timer loop.

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
		public int timer(long maxTime, int loopSteps) {
			// Setting up while loop to run for 10 seconds
			long t = System.currentTimeMillis();   // initial time
			int loops = 0;   // initialise number of loops
			int iremainder = loops % 100;   // remainder to check if number of loops if multiple of 100; boolean condition
			// while loop prints number of loops when it is a multiple of 100
			while(System.currentTimeMillis() < t + maxTime) {   // limits loop to 10 seconds past initial time
				    if (loops % loopSteps == 0 ) {
				    System.out.println("Number of loops "+loops);
			
				}
				    loops = loops + 1; // counting loops
			}
			return loops;
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
		
		
		// input first the time limit in milliseconds and then loop steps
		int total_loops = ac.timer(8000, 1000); // (milliseconds, loop steps)
		System.out.println("The total number of loops: "+total_loops);
		System.out.println();
		
		
		// trying with a loop step of 40,000
		int total_loops_40k = ac.timer(8000, 40000); // (milliseconds, loop steps)
		System.out.println();
		System.out.println("The total number of loops with 1000 loopstep: "+total_loops);
		System.out.println("The total number of loops with 40000 loopstep: "+total_loops_40k);
		// the total number of loops is much greater when the loop step is set to 40000 compared to just 1000
		
		System.out.println();
		
		System.out.println("The total number of loops is much greater when the loop step is set to 40,000, compared to when set to 1000. This is because there are less tasks to complete, in this case less numbers to output to the console, so the computer can get through more loops in a given time.");
		
		
		
		
		
	}

}
