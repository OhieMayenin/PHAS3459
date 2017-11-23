package mockExam;

import java.util.ArrayList; // import classes
import java.util.Scanner;

public class Earthquake {
	String keyMonth;	// Hash Key: month of earthquake

	// data fields belonging to each Earthquake object
	String year;		// year of earthquake
	String month;		// month of earthquake
	String day;			// day of earthquake
	String hour;		// hour of earthquake
	String minute;		// minute of earthquake
	String second;		// second of earthquake to 3 d.p.
	String latitude;	// latitude of earthquake epicentre
	String longitude;	// longitude of earthquake epicentre
	String depth;		// depth of earthquake in kilometres
	String EH1;			// location error 1 major axis
	String EH2;			// location error 2 minor axis
	String AZ;			// location error azimuth
	String EZ; 			// error on depth
	String MAG;			// magnitude of earthquake
	String ID;			// unique ID of earthquake

	/*
	 * constructor for the object Earthquake
	 * ArrayList quakeData is to contain all the data concerning an Earthquake
	 * quakeData will contain data elements in the following order:
	 * <year, month, day, hour, minute, second, latitude, longitude, depth, EH1, EH2, AZ, EZ, MAG, ID>
	 */
	public Earthquake (ArrayList<String> input) {
		// setting all the values defined above to the elements of the input ArrayList
		this.year=  input.get(0);
		this.month = input.get(1);
		this.day = input.get(2);
		this.hour = input.get(3);
		this.minute = input.get(4);
		this.second = input.get(5);
		this.latitude = input.get(6);
		this.longitude = input.get(7);
		this.depth = input.get(8);
		this.EH1 = input.get(9);
		this.EH2 = input.get(10);
		this.AZ = input.get(11);
		this.EZ  = input.get(12);
		this.MAG = input.get(13);
		this.ID = input.get(14);
		
	}






}
