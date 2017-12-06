package exam1;

import java.util.ArrayList; // import classes
import java.util.Scanner;

import mockExam.PlayerRecord;

public class IceMonth {

	String keyMonth;	// Hash Key: month of measurement

	// data fields belonging to each measurement
	String year;		// year of measurement
	String month;		// month of measurement
	String dataType;	// data source used to compile the data
	String region;		// region of measurement: either Northern(N) or Southern(S) hemisphere
	String extent;		// ice extent: total area of land or sea covered by ice in millions of square km
	String area;		// ice area: total area of actual ice in millions of square km
	
	
	/*
	 * constructor for the object IceMonth
	 * ArrayList iceData is to contain all data concerning a measurement made in a certain month
	 * iceData will contain data elements in the following order:
	 * <year, month, dataType, region, extent, area>
	 */
	public IceMonth (ArrayList<String> iceData) {
		// setting all the values defined above to the elements of the input ArrayList
		//this.keyMonth=  input.get(0);
		this.year = iceData.get(0);
		this.month = iceData.get(1);
		this.dataType = iceData.get(2);
		this.region = iceData.get(3);
		this.extent = iceData.get(4);
		this.area = iceData.get(5);
	}
	
	
	/*
	 * method takes a line of the URL file and returns an IceMonth object for that line, representing one measurement
	 */
	public static IceMonth parseLine(String line) {
		Scanner s = new Scanner(line).useDelimiter(",\\s"); // uses comma and white space as delimiter for instantiated scanner
		ArrayList<String> measurement = new ArrayList<String>(); // ArrayList to contain all data fields for one measurement
		int i = 0; // iterator
		int max = 6;
		
		// for loop adds each data element from the line being read to the ArrayList
		for (i = 0; i < max; i++) {
			measurement.add(s.next());	
		}
		
		IceMonth iceMonth = new IceMonth (measurement); // instantiate IceMonth object using the data read from this line
		
		return iceMonth;
	
	}
	
	
	public String toString() {
		
		// array of month names in order to convert numerical months to string months
		String [] monthNames = {null, "January","February","March","April","May","June","July","August", "September","October","November","December"};
		
		// convert month number to month name
		//String monthName = monthNames[Integer.parseInt(month)];
		
		String strFirst = "Month: " +month +", " +"Year: " +year +"\n" +"Data Type: " +dataType; 
		String strSecond = "Region: " +region +", " +"Ice Extent: " +extent +"km, " +"Ice Area: " +area  +"km";
		
		String strAll = "\n" +"\n" +strFirst + "\n" + strSecond +"\n";

		return strAll;
	}
	
	// writing get methods for all data fields part of IceMonth object
	
	public String getYear() {
		return this.year;
	}

	public String getMonth() {
		return this.month;
	}

	public String getDataType() {
		return this.dataType;
	}

	public String getRegion() {
		return this.region;
	}

	public String getExtent() {
		return this.extent;
	}
	
	public String getArea() {
		return this.area;
	}
	
}
