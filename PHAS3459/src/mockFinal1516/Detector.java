/*
 * defines detector object
 * holds information for each detector
 */

package mockFinal1516;

public class Detector {
	String detectorID;
	String distance; // distance of detector from source in metres
	
	public Detector(String detector, String distance) {
		this.detectorID = detector;
		this.distance = distance;
	}
	
	public String toString () {
		String str = "Detector Name: " +detectorID + "\n" +"Distance: " +distance;
		
		return str;
	}
	
}
