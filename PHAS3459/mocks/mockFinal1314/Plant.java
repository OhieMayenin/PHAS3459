/*
 * defines plant object
 * subclass of Species
 */

package mockFinal1314;

public class Plant extends Species{
//	String latitude;
//	String longitude;
//	String code;
	String height;
	String name;
	
	public Plant (String latitude, String longitude, String code, String height) {
		super(latitude,longitude,code);
//		this.latitude = latitude;
//		this.longitude = longitude;
//		this.code = code;
		this.height = height;
		this.name = Mock1314MainPt1.speciesDatabase.get(code);
	}
	
	public String toString () {
		String finalStr;
		String str1 = "\n" +"Latitude, Longitude: " +latitude +"," +longitude;
		String str2 = "Name: " +name +"\t" +"Code:" +code +"\t" +"Height: " +height;
		
		finalStr = "\n" +str1 +"\n" +str2;
		return finalStr;
		}
}
