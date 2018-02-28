/**
 * this class defines a CountdownTask object
 * counts down in seconds from a specified start time
 */

package module8;

public class CountdownTask implements Runnable{
	public int time;


	/*
	 * constructor takes arg for number of seconds to count down
	 */
	public CountdownTask (int setTimer) {
		this.time = setTimer;
	}

	// gets time in milliseconds
	public long getTime() {
		return System.currentTimeMillis();
	}
	
	// run method
	public void run() {
		
		System.out.println(time); // print starting time
		long initialTime  = getTime();
		long currentTime;

		// loop prints new time after 1000 ms have passed
		while (time > 0) {
			if (((currentTime = getTime()) - initialTime) >= 1000) {
				time = time - 1;
				System.out.println(time);
				initialTime  = getTime();
			}
		}
		System.out.println("Countdown has finished.");
		return;
	}
	

}
