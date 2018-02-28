/*
 * defines Tide object
 * to hold data extracted from each line in URL
 */

package mockFinal1415;

public class Tide {
	String date;
	String time;
	String loc;
	String seaLevel;
	String predicted;
	
	/**
	 * constructor for Tide object
	 * @param date - date of measurement, dd/mm/yyyy
	 * @param time - time of measurement hh:mm
	 * @param loc - location code
	 * @param seaLevel - measured sea level in metres
	 * @param predicted - predicted sea level in metres
	 */
	public Tide(String date, String time, String loc, String seaLevel, String predicted) {
		this.date = date;
		this.time = time;
		this.loc = loc;
		this.seaLevel = seaLevel;
		this.predicted = predicted;
		
		
	}
	
	/*
	 * toString method for Tide objects
	 */
	public String toString() {
		String finalStr;
		String str1 = "Location of Measurement: " +loc;
		String str2 = "Date of Measurement: " + date + "\t" + "Time of Measurement: " +time;
		String str3 = "Sea Level: " +seaLevel +"\t" +"Predicted: " +predicted;;
		finalStr = "\n" +str1 + "\n" + str2 +"\n" +str3;
		return finalStr;
	}
}
