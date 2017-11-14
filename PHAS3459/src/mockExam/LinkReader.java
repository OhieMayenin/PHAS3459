/**
 * 	This class will contain methods to read the URL for data regarding baseball players
 */

package mockExam;

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


public class LinkReader {
	
	
	public static HashMap<String,ArrayList<String>> readURL(String urlName) throws IOException {
		
		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		//Scanner s = new Scanner(url); // instantiate scanner for input URL
		Scanner s = new Scanner(url).useDelimiter("\t"); // uses tab as delimiter for scanner
		
		ArrayList<String> data = new ArrayList<String>(); // instantiate ArrayList to hold strings parsed by scanner from each line
		HashMap<String, ArrayList<String>> dataHashMap = new HashMap<String,ArrayList<String>>(); // instantiate HashMap to store this data for each player key/name 
		String keyName;
		
		// loop will scan the whole URL and store player data in HashMap using one ArrayList for each player.
		while (s.hasNext()) {
			// String line = "";
			// line=bufferedreader.readLine() != null;
			
			// this while loop fills ArrayList with data from one line
			while (s.hasNext() && s.next() != "\n") {
				String element = s.next(); // using tab delimiter
				data.add(element); // append to data ArrayList
			}
		
		keyName = data.get(0); // get player name/key for line just read
		
		// stores the ArrayList into HashMap once it contains all data fields from one line
		// then resets the ArrayList for then next line
		dataHashMap.put(keyName, data);
		data = new ArrayList<String>();
		}
		
		//s.close();
		
		return dataHashMap;
	
	
	
	
	}
	
	
	public static void main(String[] args) {
		String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/MLB2001Hitting.txt";
	
		try {
		HashMap<String, ArrayList<String>> playerDatabase = readURL(urlName);
		System.out.println(playerDatabase);
		}
		catch (IOException e) {e.printStackTrace();}
	
	// key "player" for list of statistics stored in HashMap in order

	
	}

}
