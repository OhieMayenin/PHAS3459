/*
 * defines methods to read and sort data
 * into appropriate data collections
 */

package mockFinal1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataReader {
	String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/";
	static ArrayList<Detector> detectors;

	public static HashMap<String,ArrayList<PulseData>> sortData(String urlName) throws IOException {
		HashMap<String,ArrayList<PulseData>> database = new HashMap<String,ArrayList<PulseData>>();

		String detectorID;
		String distance;
		String line = "";
		detectors = new ArrayList<Detector>();

		// extracting detector data from detectors.txt
		URL u = new URL(urlName+"detectors.txt"); // url to detector data
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url);

		while (s.hasNext()) {
			detectorID = s.next();
			distance = s.next();

			Detector detector = new Detector(detectorID,distance);
			detectors.add(detector);
		}

		s.close(); // detectors.txt read
		
		System.out.println(detectors);

		// extracting detector data from detectors.txt
		URL u2 = new URL(urlName+"signals.txt"); // url to detector data
		InputStream is_url2 = u2.openStream(); // inputs URL as bytes
		InputStreamReader isr_url2 = new InputStreamReader(is_url2); // wrap input stream
		BufferedReader url2 = new BufferedReader(isr_url2); // reads large chunk of data into memory
		


		while ((line = url2.readLine()) != null) {
			ArrayList<String> data = new ArrayList<String>();
			Scanner s2 = new Scanner(line);
			detectorID = s2.next();

			while (s2.hasNext()) {
				data.add(s2.next());
			}

			PulseData pulse = new PulseData(detectorID,data);
					
			for (Detector det : detectors) { 
				ArrayList<PulseData> pulses = database.get(det.detectorID);
				if (pulses == null) {
					database.put(det.detectorID, new ArrayList<PulseData>() );
				}
				
				if (det.detectorID.equals(detectorID)) {
				break;
				}
			}
			
			ArrayList<PulseData> pulses = database.get(detectorID);
			if (pulses == null) {
				database.put(detectorID, new ArrayList<PulseData>() );
			}
			database.get(detectorID).add(pulse);
		}

		return database;
	}


}
