package module6;

import java.io.BufferedReader; // import classes
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import mockExam.PlayerRecord;

public class TestDataPoints {

	public static void main(String[] args) {
		String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt";
		
		try {
		ArrayList<DataPoint> dataFromURL = dataFromURL(urlName);
		System.out.println(dataFromURL);
		}
		
		catch(IOException e) {e.printStackTrace();}
	}


	public static DataPoint parseLine(String line) {
		Scanner s = new Scanner(line); // instantiate scanner for each line
		DataPoint dataPoint = null; // initialise dataPoint object to be returned
		
		double x = Double.parseDouble(s.next());
		double y = Double.parseDouble(s.next());
		double ey = Double.parseDouble(s.next());

		if(s.next() != "\n") {
			String label = s.next();
			dataPoint = new LabelledDataPoint(x,y,ey,label);
			} 
		
		else if (s.next() == "\n") {
			String label = null;
			dataPoint = new DataPoint(x,y,ey);
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
		ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>();
		
		while ((line = url.readLine()) != null) {
			DataPoint dataPoint = parseLine(line);
			dataPoints.add(dataPoint);
		}
		
		return dataPoints;
		
		
	}

}
