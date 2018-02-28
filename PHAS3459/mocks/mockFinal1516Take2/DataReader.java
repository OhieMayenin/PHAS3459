/**
 * holds methods to unpack data from URL
 */

package mockFinal1516Take2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class DataReader {
	String urlMain; // umbrella URL where .txt files are located

	/**
	 * constructor for DataReader
	 * @param urlName - umbrella URL contains all files to be read
	 */
	public DataReader(String urlName) {
		this.urlMain = urlName;
	}

	/**
	 * 
	 * @param urlName - name of .txt file to be read in URL
	 * @return - ArrayList of Pulse objects
	 * @throws IOException
	 */
	public ArrayList<Pulse> readURL(String urlName) throws IOException {
		String line = "";


		ArrayList<Pulse> pulses = new ArrayList<Pulse>();

		URL u = new URL(urlMain+urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory


		// parse each line and instantiate pulse object
		while ((line = url.readLine()) != null) {
			Pulse pulse = parseLine(line);
			pulses.add(pulse); // add new Pulse object to ArrayList
		}

		return pulses;
	}

	/**
	 * reads each line from pulse URL
	 * @param line - line from the Pulse .txt file
	 * @return - Pulse object
	 */
	public static Pulse parseLine(String line) {
		String detector = "";
		ArrayList<Double> data = new ArrayList<Double>();

		Scanner s2 = new Scanner(line);

		detector = s2.next();

		while (s2.hasNext()) {
			data.add(Double.parseDouble(s2.next()));
		}
		
		Pulse pulse = new Pulse (detector, data);

		s2.close();

		return pulse;
	}
	
	/**
	 * gets detector information from .txt file
	 * @param urlDetectors - name of .txt file in the URL
	 * @return - HashMap with <key,value> ==> <detectorID, distance (metres)>
	 * @throws IOException
	 */
	public HashMap<String,String> readDetectors(String urlDetectors) throws IOException {
		HashMap<String,String> detectorDatabase = new HashMap<String,String>();
		String detector; // detector ID
		String distance; // distance in metres

		URL u = new URL(urlMain+"detectors.txt"); // url to detector data
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url);

		// adds one HashMap entry per line
		while (s.hasNext()) {
			detector = s.next();
			distance = s.next();

			detectorDatabase.put(detector, distance); // put into HashMap
		}

		return detectorDatabase;

	}
}
