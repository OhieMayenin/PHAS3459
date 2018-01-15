/*
 * defines Pulse object
 * holds voltage data from pulse 
 * detected by a certain detector
 */

package mockFinal1516;

import java.util.ArrayList;

public class PulseData {
	String detector;
	ArrayList<String> data;
	double sum = 0;
	double amplitude;
	int arrivalTime;

	public PulseData (String detector, ArrayList<String> data) {
		this.detector = detector;
		this.data = data;
		calculateAmp();
		calculateArrivTime();
	}

	private double calculateAmp() {
		amplitude = 0;
		for (int i = 0; i < data.size(); i++) {
			if (Double.parseDouble(data.get(i)) > amplitude) {
				amplitude = Double.parseDouble(data.get(i));
			}
		}
		return amplitude;
	}

	private double calculateArrivTime() {
		arrivalTime = 0;
		for (int i = 0; i < data.size(); i++) {
			arrivalTime++;
			if (Double.parseDouble(data.get(i)) == amplitude) {
				break;
			}
		}
		return this.arrivalTime;
	}

	public double getAmplitude () {
		return this.amplitude;
	}

	public double getArrivalTime () {
		return this.arrivalTime;
	}

	public String toString () {
		String str1 = "\n"+"Detector ID: " +detector +"\n";
		String finalStr = str1;

		return finalStr;
	}
}
