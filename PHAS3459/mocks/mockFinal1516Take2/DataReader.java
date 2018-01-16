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
	String urlMain;

	/*
	 * constructor sets umbrella URL name
	 */
	public DataReader(String urlName) {
		this.urlMain = urlName;
	}

	public ArrayList<Pulse> readURL(String urlName) throws IOException {
		String line = "";


		ArrayList<Pulse> pulses = new ArrayList<Pulse>();

		URL u = new URL(urlMain+urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory


		// parse each line and instantiate tide object
		while ((line = url.readLine()) != null) {
			Pulse pulse = parseLine(line);
			pulses.add(pulse); // add new Tide object to ArrayList
		}

		return pulses;
	}

	/*
	 * parses a line from the url file
	 * returns a Tide object representing data from that line
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

	public HashMap<String,String> readDetectors(String urlDetectors) throws IOException {
		HashMap<String,String> detectorDatabase = new HashMap<String,String>();
		String detector;
		String distance;

		// extracting detector data from detectors.txt
		URL u = new URL(urlMain+"detectors.txt"); // url to detector data
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url);

		while (s.hasNext()) {
			detector = s.next();
			distance = s.next();

			detectorDatabase.put(detector, distance);
		}

		return detectorDatabase;

	}
}
