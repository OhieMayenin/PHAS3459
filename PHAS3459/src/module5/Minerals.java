package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Minerals {
	

	public static HashMap<Double,Double> hashMapFromMassURL(String urlName) throws IOException {
		ArrayList<Double> massData = new ArrayList<Double>();
		
		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url);
		HashMap<Double, Double> masses = new HashMap <Double, Double>(); // <Code, Mass>
		
		while (s.hasNext()) {
			double num = Double.parseDouble(s.next()); // parse string from resource as double
			massData.add(num);
			
			if (massData.size() >=2) {
				masses.put(massData.get(0), massData.get(1)); // (key, value)
				massData = new ArrayList<Double>(); // reset double list for next element
			}
		}
		return masses;
		
	}
	
	// this method retains doubles as strings: check if this is fine
	public static HashMap<String,String> hashMapFromLocationURL(String urlName) throws IOException {
		ArrayList<String> locData = new ArrayList<String>();
		
		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url);
		HashMap<String,String> locations = new HashMap <String, String>(); // <Code, Location>
		
		while (s.hasNext()) {
			String num = s.next(); // parse string from resource as double
			locData.add(num);
			
			if (locData.size() >=2) {
				locations.put(locData.get(1), locData.get(0)); // (key, value)
				locData = new ArrayList<String>(); // reset double list for next element
			}
		}
		return locations;
	}

		
	
	
	
	
	public static void main(String[] args) {
		String urlMass = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt";
		String urlLocation = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt";
		
		try {
		hashMapFromMassURL(urlMass);
		hashMapFromLocationURL(urlLocation);
		
		double largestMass;
		}
		catch (IOException e){e.printStackTrace();}
	}
}
