/** This class will read data from URLs
 *  will then create HashMaps to store this data
 *  data will then be analysed for significant values
 */

package module5;

import java.io.BufferedReader; // import classes
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;


public class Minerals {
	
	/*	writing method that reads URL and returns HashMap object
	 * 	takes the URL name String as argument
	 * 	reading doubles which represent mass of elements
	 */
	public static HashMap<Double,Double> hashMapFromMassURL(String urlName) throws IOException {
		
		ArrayList<Double> massData = new ArrayList<Double>(); // instantiate new ArrayList for mass values
		
		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url); // scan URL
		
		HashMap<Double, Double> masses = new HashMap <Double, Double>(); // instantiate HashMap: <Code, Mass>
		
		// while loop will read URL data and add them to HashMap
		while (s.hasNext()) {
			double num = Double.parseDouble(s.next()); // parse string from resource as double
			massData.add(num); // add this double to ArrayList
			
			// if loop will add ArrayList doubles to HashMap once two doubles are added to ArrayList
			if (massData.size() >=2) {
				masses.put(massData.get(0), massData.get(1)); // add doubles to HashMap: (key, mass value)
				massData = new ArrayList<Double>(); // reset double list for next element
			}
		}
		
		return masses;
		
	}
	
	/*	writing method that reads URL and returns HashMap object
	 * 	takes the URL name String as argument
	 * 	reading Strings which represent element locations
	 */
	public static HashMap<String,String> hashMapFromLocationURL(String urlName) throws IOException {
		
		ArrayList<String> locData = new ArrayList<String>(); // instantiate ArrayList of strings
		
		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url); // scan URL
		
		HashMap<String,String> locations = new HashMap <String, String>(); // instantiate HashMap: <Code, Location>
		
		// while loop will read strings and add them to HashMap for each element
		while (s.hasNext()) {
			String num = s.next(); // this time will be parsed as string
			locData.add(num); // add this String to ArrayList
			
			// if loop will add data for each element to HashMap
			if (locData.size() >=2) {
				locations.put(locData.get(1), locData.get(0)); // put values in HashMap: (key, location)
				locData = new ArrayList<String>(); // reset ArrayList for next element
			}
		}
		
		return locations;
	}

	// main method	
	public static void main(String[] args) {
		String urlMass = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt"; // URL String containing mass data
		String urlLocation = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt"; // URL String containing location data
		
		
		try {
			
		HashMap<Double, Double> masses = hashMapFromMassURL(urlMass); // calling HashMap method for masses
		HashMap<String, String> locations = hashMapFromLocationURL(urlLocation); // calling HashMap method for locations
		
		double largestMass = Collections.max(masses.values()); // find largest mass value from HashMap
		double smallestMass = Collections.min(masses.values()); // find smallest mass value from HashMap
		double keyLarge = 0; // initialise key for largest mass
		double keySmall = 0; // initialise key for smallest mass

		// for loop finds key corresponding to largest mass
		for(Entry<Double, Double> entry: masses.entrySet()) {
			
			// if loop sets key value corresponding to entry value which equals largestMass
			if (entry.getValue().equals(largestMass)) {
				keyLarge = entry.getKey(); // set key value to largestMass entry
			}
		}
		
		// for loop finds key corresponding to smallest mass
		for(Entry<Double,Double> entry: masses.entrySet()) {
			
			// if loop sets key value corresponding to entry value which equals smallestMass
			if (entry.getValue().equals(smallestMass)) {
				keySmall = entry.getKey(); // set key value to smallestMass entry
			}
		}
		
		// double must be cast to String to get our location
		
		// largest mass key
		int keyIntLarge = (int) Math.round(keyLarge); // cast double key to integer
		String keyStringLarge = String.valueOf(keyIntLarge); // cast integer key to String
		String locLargestMass = locations.get(keyStringLarge); // set location corresponding to the key of the largest mass
		
		// smallest mass key
		int keyIntSmall = (int) Math.round(keySmall); // cast double key to integer
		String keyStringSmall = String.valueOf(keyIntSmall); // cast integer key to String
		String locSmallestMass = locations.get(keyStringSmall); // set location corresponding to the key of the smallest mass
		
		
		// printing final statements to console
		System.out.println("The largest mass: "+largestMass+"g belongs to the key: "+keyIntLarge+" and is found in the location: "+ locLargestMass + '\n');
		System.out.println("The smallest mass: "+smallestMass+"g belongs to the key: "+keyIntSmall+" and is found in the location: "+ locSmallestMass);
		
		
		
		}
		catch (IOException e){e.printStackTrace();}
	}
}
