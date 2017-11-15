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


	public static HashMap<String,PlayerRecord> readURL(String urlName) throws IOException {

		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory


		String line = "";
		String keyName;
		String element;
		int i = 0;
		HashMap<String,PlayerRecord> playerDatabase = new HashMap<String,PlayerRecord>();
		ArrayList<String> data = new ArrayList<String>();

		while ((line=url.readLine()) != null) {
			//System.out.println(line);
			Scanner s = new Scanner(line).useDelimiter("\t"); // uses tab as delimiter for scanner

			element = s.next();
			data.add(element);
			if (data.size() > 12) {
				PlayerRecord playerRecord = new PlayerRecord(data);
				keyName = data.get(0); 
				playerDatabase.put(keyName, playerRecord);
				data = new ArrayList<String>();
				s.close();
			}
		}


		PlayerRecord playerRecord = new PlayerRecord(data);

		return playerDatabase;		
	}

	public static void main(String[] args) {
		String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/MLB2001Hitting.txt";

		try {
			HashMap<String, PlayerRecord> playerDatabase = readURL(urlName);
			System.out.println(playerDatabase);
		}
		catch (IOException e) {e.printStackTrace();}

		// key "player" for list of statistics stored in HashMap in order


	}

}
