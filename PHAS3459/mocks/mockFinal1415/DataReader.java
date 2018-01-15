/*
 * defines methods that will be used
 * to read the URL and handle the 
 * extracted data accordingly
 */

package mockFinal1415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataReader {
	String urlMain;
	
	/*
	 * constructor sets umbrella URL name
	 */
	public DataReader(String urlName) {
		this.urlMain = urlName;
	}
	
	/*
	 * sorts input ArrayLists
	 * outputs HashMap where the key is the year of measurements
	 * and the value is an ArrayList of Tide objects
	 * representing measurements in that year
	 */
	public HashMap<String,ArrayList<Tide>> sort(ArrayList<Tide> y99, ArrayList<Tide> y00, ArrayList<Tide> y01 ) {
		HashMap<String,ArrayList<Tide>> tideDatabase = new HashMap<String,ArrayList<Tide>>();
		
		// put year of measurements as key for hash map
		tideDatabase.put(y99.get(0).date.substring(6, 10),y99);
		tideDatabase.put(y00.get(0).date.substring(6, 10),y00);
		tideDatabase.put(y01.get(0).date.substring(6, 10),y01);
		
		return tideDatabase;
	}
	
	/*
	 * takes url name specifying a file to be read
	 * outputs ArrayList of Tide objects
	 * representing all measurements in that file/year
	 */
	public ArrayList<Tide> readURL(String urlName) throws IOException {
		String line = "";
		
		
		ArrayList<Tide> tides = new ArrayList<Tide>();
		
		URL u = new URL(urlMain+urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		
		
		// parse each line and instantiate tide object
		while ((line = url.readLine()) != null) {
			Tide tide = parseLine(line);
			tides.add(tide); // add new Tide object to ArrayList
			}
		
		return tides;
	}
		
	/*
	 * parses a line from the url file
	 * returns a Tide object representing data from that line
	 */
	public static Tide parseLine(String line) {
		String loc;
		String year;
		String month;
		String day;
		String hour;
		String minute;
		String seaLevel;
		String predicted;
		
		Scanner s2 = new Scanner(line);
		loc = s2.next();
		year = s2.next();
		month = s2.next();
		day = s2.next();
		hour = s2.next();
		minute = s2.next();
		seaLevel = s2.next();
		predicted = s2.next();
		
		StringBuilder date = new StringBuilder();
		date.append(day +"/" +month +"/" +year);
		StringBuilder time = new StringBuilder();
		time.append(hour +":" +minute);
		
		Tide tide = new Tide(date.toString(), time.toString(), loc, seaLevel, predicted);
		
		s2.close();
				
		return tide;
	}
	
	/*
	 * read data for the sites measurements were taken at
	 * takes input url string for file to be read
	 * outputs HashMap with key site code and value site location
	 */
	public HashMap<String,String> extractSites(String urlSites) throws IOException {
		HashMap<String,String> sites = new HashMap<String,String>();
		
		URL u = new URL(urlMain+urlSites); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url);
		
		String site = "";
		String port = "";
		while (s.hasNext()) {
			site = s.next();
			port = s.next();
			sites.put(port, site);
		}
		
		return sites;
	}
	
	
	// METHODS FOR PART 3 //
	
	public ArrayList<Tide> readURLPt3(String urlName) throws IOException {
		String line = "";
		
		
		ArrayList<Tide> tides = new ArrayList<Tide>();
		
		URL u = new URL(urlMain+urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		
		while ((line = url.readLine()) != null) {
			Tide tide = parseLinePt3(line);
			tides.add(tide);
			}
		
		return tides;
	}
	
	public static Tide parseLinePt3(String line) {
		String loc;
		String year;
		String month;
		String day;
		String hour;
		String minute;
		String seaLevel;
		String predicted;
		
		Scanner s2 = new Scanner(line);
		year = s2.next();
		month = s2.next();
		day = s2.next();
		hour = s2.next();
		minute = s2.next();
		loc = s2.next();
		seaLevel = s2.next();
		predicted = s2.next();
		
		StringBuilder date = new StringBuilder();
		date.append(day +"/" +month +"/" +year);
		StringBuilder time = new StringBuilder();
		time.append(hour +":" +minute);
		
		Tide tide = new Tide(date.toString(), time.toString(), loc, seaLevel, predicted);
				
		return tide;
	}
	
}
