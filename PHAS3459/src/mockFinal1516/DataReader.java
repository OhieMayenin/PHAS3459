/*
 * defines methods to read and sort data
 * into appropriate data collections
 */

package mockFinal1516;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataReader {
	String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/";
	
	public static HashMap<Detector,ArrayList<PulseData>> sortData(String urlName) throws Exception {
		HashMap<Detector,ArrayList<PulseData>> database = new HashMap<Detector,ArrayList<PulseData>>();
		
		String detectorID;
		String distance;
		String line = "";
		ArrayList<Detector> detectors = new ArrayList<Detector>();
		
		// extracting detector data from detectors.txt
		URL u = new URL(urlName+"detectors.txt"); // url to detector data
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url);
		
		while ((line = url.readLine()) != null) {
			detectorID = s.next();
			distance = s.next();
			
			Detector detector = new Detector(detectorID,distance);
			detectors.add(detector);
		}
		
		s.close(); // detectors.txt read
		
		
		
		return database;
	}
	

}
