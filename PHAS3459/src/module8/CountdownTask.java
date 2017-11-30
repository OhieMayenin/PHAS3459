package module8;

public class CountdownTask implements Runnable{
	int time;


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

	public void run() {
		long initialTime  = getTime();
		long currentTime;

		while (time !=0) {
			if (((currentTime = getTime()) - initialTime) >= 1000) {
				time = time - 1;
				System.out.println(time);
				initialTime  = getTime();
			}
		}


	}
}
