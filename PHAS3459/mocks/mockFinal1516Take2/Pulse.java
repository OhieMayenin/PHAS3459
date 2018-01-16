package mockFinal1516Take2;

import java.util.ArrayList;

public class Pulse {
	String detector;
	ArrayList<Double> pulse;
	double amplitude;
	int arrivalTime;

	public Pulse (String detectorID, ArrayList<Double> pulse) {
		this.detector = detectorID;
		this.pulse = pulse;

		double maxSignal = 0;
		int count = -1;
		int arrivalTime = 0;
		
		// determine arrival time and amplitude
		for (double signal : pulse) {
			count++;
			if (signal > maxSignal) {
				maxSignal = signal;
				arrivalTime = count;
			}
		}
		this.amplitude = maxSignal;
		this.arrivalTime = arrivalTime;
	}

	public String toString () {
		String str1 = "Detector: " +detector;
		String str2 = "Amplitude: " +amplitude;
		String str3 = "Arrival Time: " +arrivalTime;

		String finalStr = "\n" +str1+ "\n" +str2 +"\n" +str3 +"\n";

		return finalStr;
	}
	
}
