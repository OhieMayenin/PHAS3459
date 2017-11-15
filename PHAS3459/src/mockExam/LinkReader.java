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


	public static ArrayList<PlayerRecord> readURL(String urlName) throws IOException {

		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory


		String line = "";
		String keyTeamName ="";
		PlayerRecord playerData;
		int i = 0;

		ArrayList<PlayerRecord> allPlayers = new ArrayList<PlayerRecord>();

		while ((line = url.readLine()) != null) {
			if (line.contains(".")) {
				// if loop skips any lines without numerical data i.e. the first two
				playerData = PlayerRecord.parseLine(line);
				allPlayers.add(playerData);

			}
		}

		return allPlayers;
	}
	
	/*
	 * method which takes ArrayList input of all PlayerRecord objects for all players
	 * sorts them into ArrayLists each representing a different team
	 * adds these team ArrayLists to HashMap, where team name is the key
	 */
	public static HashMap<String,ArrayList<PlayerRecord>> sortIntoHashMap(ArrayList<PlayerRecord> allPlayers) throws IOException {
		HashMap<String,ArrayList<PlayerRecord>> teamDatabase = new HashMap<String,ArrayList<PlayerRecord>>();

		// Loop over complete Batter list
		for (PlayerRecord player : allPlayers) {

			// Retrieve team for that Batter
			String keyTeamName = player.getTeam();

			// Extract Batter list from HashMap using this team
			ArrayList<PlayerRecord> thisPlayerList = teamDatabase.get(keyTeamName);

			// If this list is empty, create a new ArrayList of Batters
			if (thisPlayerList == null) {
				teamDatabase.put(keyTeamName, new ArrayList<PlayerRecord>());
			}

			// Add current Batter to list of Batters for that team
			teamDatabase.get(keyTeamName).add(player);

		}
		
		return teamDatabase;
	}

	public static void main(String[] args) {
		String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/MLB2001Hitting.txt";

		try {
			ArrayList<PlayerRecord> allPlayers = readURL(urlName);
			System.out.println(allPlayers);
			HashMap<String, ArrayList<PlayerRecord>> teamDatabase = sortIntoHashMap(allPlayers); 
			
		}

		catch (IOException e) {e.printStackTrace();}



	}

}
