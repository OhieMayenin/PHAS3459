/**	This class will test the DataPoint classes
 * 	will read and extract data from a URL
 */

package module6;

import java.io.BufferedReader; // import classes
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class TestDataPoints {

	public static void main(String[] args) {
		String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt"; // string of URL to be read

		try {
			ArrayList<DataPoint> dataFromURL = dataFromURL(urlName); // read URL and return ArrayList of DataPoints
			System.out.println(dataFromURL);
		}

		catch(IOException e) {e.printStackTrace();}
	}


	public static DataPoint parseLine(String line) {
		Scanner s = new Scanner(line); // instantiate scanner for each line
		DataPoint dataPoint = null; // dataPoint to be returned

		double x = Double.parseDouble(s.next());
		double y = Double.parseDouble(s.next());
		double ey = Double.parseDouble(s.next());


		// if and else loops check if label entry was read
		if(s.hasNext()) {
			String label = s.next();
			dataPoint = new LabelledDataPoint(x,y,ey,label); // labelled data point if label exists
		} 

		else {
			String label = null;
			dataPoint = new DataPoint(x,y,ey); // normal data point if label entry is null
		}

		s.close();

		return dataPoint;

	}		

	public static ArrayList<DataPoint> dataFromURL (String urlName) throws IOException {
		URL u = new URL (urlName);
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory

		String line = "";
		ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>(); // ArrayList to contain DataPoints


		// while loop reads URL data line by line
		while ((line = url.readLine()) != null) {
			DataPoint dataPoint = parseLine(line);
			dataPoints.add(dataPoint);
		}

		return dataPoints;


	}

}
