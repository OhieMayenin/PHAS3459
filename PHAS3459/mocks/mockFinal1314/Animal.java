package mockFinal1314;

public class Animal {
	String latitude;
	String longitude;
	String code;
	String height;
	String name;
	
	public Animal (String latitude, String longitude, String code) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.code = code;
		this.name = Mock1314MainPt3.speciesDatabase.get(code);
	}
	
	public String toString () {
		String finalStr;
		String str1 = "\n" +"Latitude, Longitude: " +latitude +"," +longitude;
		String str2 = "Name: " +name +"\t" +"Code:" +code;
		
		finalStr = "\n" +str1 +"\n" +str2;
		return finalStr;
		}
}
