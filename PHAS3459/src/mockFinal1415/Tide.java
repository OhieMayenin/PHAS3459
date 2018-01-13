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
	
	public Tide(String date, String time, String loc, String seaLevel, String predicted) {
		this.date = date;
		this.time = time;
		this.loc = loc;
		this.seaLevel = seaLevel;
		this.predicted = predicted;
		
		
	}
	
	public String toString() {
		String finalStr;
		String str1 = "Location of Measurement: " +loc;
		String str2 = "Date of Measurement: " + date + "\t" + "Time of Measurement: " +time;
		String str3 = "Sea Level: " +seaLevel +"\t" +"Predicted: " +predicted;;
		finalStr = "\n" +str1 + "\n" + str2 +"\n" +str3;
		return finalStr;
	}
}
