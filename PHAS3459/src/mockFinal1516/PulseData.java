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
	double amplitude = 0;
	int arrivalTime = 0;

	public PulseData (String detector, ArrayList<String> data) {
		this.detector = detector;
		this.data = data;
		calculateAmp();
		calculateArrivTime();
	}

	private double calculateAmp() {
		//this.amplitude = 0;
		for (int i = 0; i < data.size(); i++) {
			if (Double.parseDouble(data.get(i)) > this.amplitude) {
				this.amplitude = Double.parseDouble(data.get(i));
			}
		}
		return this.amplitude;
	}

	private double calculateArrivTime() {
		for (int i = 0; i < data.size(); i++) {
			this.arrivalTime++;
			if (Double.parseDouble(data.get(i)) == this.amplitude) {
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
		String str2 = ""+data.get(0)+", " +data.get(1);
		String finalStr = str1+str2;

		return finalStr;
	}
}
