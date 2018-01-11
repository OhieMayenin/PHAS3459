/*
 * defines Pulse object
 * holds voltage data from pulse 
 * detected by a certain detector
 */

package mockFinal1516;

import java.util.ArrayList;

public class PulseData {
	String detector;
	ArrayList<Double> data;
	
	public PulseData (String detector, ArrayList<Double> data) {
		this.detector = detector;
		this.data = data;
	}
	
//	public String toString () {
//		String finalStr = "";
//		
//		String finalStr = ?;
//		return finalStr;
//	}
}
