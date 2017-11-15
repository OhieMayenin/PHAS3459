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


	public static HashMap<String,ArrayList<PlayerRecord>> readURL(String urlName) throws IOException {

		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory


		String line = "";
		String keyTeamName ="";
		String element;
		int i = 0;
		HashMap<String,ArrayList<PlayerRecord>> teamDatabase = new HashMap<String,ArrayList<PlayerRecord>>();
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<PlayerRecord> allPlayers = new ArrayList<PlayerRecord>();

		//Scanner s = new Scanner(url).useDelimiter("\t"); // uses tab as delimiter for scanner

		while ((line = url.readLine()) != null) {
			//System.out.println(line);
			Scanner s = new Scanner(line).useDelimiter("\t"); // uses tab as delimiter for scanner

			if (line.contains(".")) {
				// if loop skips any lines without actual data i.e. the first two


				for (i = 0; i < 12; i++ ) {
					element = s.next();
					//System.out.println(element);
					data.add(element);			
				}
				keyTeamName = data.get(1);
				System.out.println(keyTeamName);

				PlayerRecord playerData = new PlayerRecord(data);



				allPlayers.add(playerData);
			}
			}

				if (teamDatabase.get(keyTeamName) ==null) {
					ArrayList<PlayerRecord> teamPlayers = new ArrayList<PlayerRecord>();

					for (i = 0; i < allPlayers.size(); i++) {
						if(allPlayers.get(i).getTeam() == keyTeamName) {
							teamPlayers.add(allPlayers.get(i));
						}
					}
					System.out.println(teamPlayers);
					teamDatabase.put(keyTeamName, teamPlayers);
				}
		
		return teamDatabase;
	}


	public static void main(String[] args) {
		String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/MLB2001Hitting.txt";

		try {
			HashMap<String, ArrayList<PlayerRecord>> playerDatabase = readURL(urlName);
			System.out.println(playerDatabase);

					}
		catch (IOException e) {e.printStackTrace();}



	}

}
