/*
 * superclass of all Species objects
 * includes subclasses Animal and Plant
 */

package mockFinal1314;

public class Species {
	String latitude;
	String longitude;
	String code;
	
	public Species (String latitude, String longitude, String code) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.code = code;
	}

}
