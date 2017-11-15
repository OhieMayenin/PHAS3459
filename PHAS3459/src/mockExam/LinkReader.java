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
import java.util.Collection;
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
		//Scanner s = new Scanner(url).useDelimiter("\t"); // uses tab as delimiter for scanner

		while ((line = url.readLine()) != null) {
			//System.out.println(line);
			Scanner s = new Scanner(line).useDelimiter("\t"); // uses tab as delimiter for scanner

			if (line.contains(".")) {
				// if loop skips any lines without actual data i.e. the first two
				keyName = s.next(); 

				for (i = 0; i < 12; i++ ) {
					element = s.next();
					//System.out.println(element);
					data.add(element);			
				}

				PlayerRecord playerData = new PlayerRecord(data);
				playerDatabase.put(keyName, playerData);
				data = new ArrayList<String>();

			}
		}

		return playerDatabase;
	}


	public static void main(String[] args) {
		String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/MLB2001Hitting.txt";

		try {
			HashMap<String, PlayerRecord> playerDatabase = readURL(urlName);
			//System.out.println(playerDatabase);
			Collection <PlayerRecord> values = playerDatabase.values();
			
			// tests
			PlayerRecord rowandA = playerDatabase.get("Rowand, A");
			System.out.println(rowandA.getPos());
			
						
			
			// number of players stored in HashMap
			int numberOfPlayers = playerDatabase.values().size();
			System.out.println("The number of players stored in the HashMap database: "+numberOfPlayers);
			
			
			// scan for most home runs
			int i = 0;
			for (i = 0; i < playerDatabase.values().size(); i++) {
				Collection<PlayerRecord> vals = playerDatabase.values();
				
				
				
			}
		}
		catch (IOException e) {e.printStackTrace();}

		// key "player" for list of statistics stored in HashMap in order


	}

}
