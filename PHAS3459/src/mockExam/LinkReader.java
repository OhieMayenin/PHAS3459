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
		String keyTeamName = "";
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
			//System.out.println(allPlayers);
			HashMap<String, ArrayList<PlayerRecord>> teamDatabase = sortIntoHashMap(allPlayers); 
			//System.out.println(teamDatabase.get("MIL"));

			System.out.println("Total number of players: " +allPlayers.size()); // total number of players



			// finding player who hit most Home Runs

			double maxHomeRuns = 0; // initialise max home runs
			PlayerRecord playerMaxHR = null; // initialise PlayerRecord for player who hit max home runs

			// find max number of home runs hit
			for (PlayerRecord player : allPlayers) {
				if (Double.parseDouble(player.getHR())> maxHomeRuns) {
					maxHomeRuns = Double.parseDouble(player.getHR());
				}
			}

			// find player who hit this max number of home runs
			for (PlayerRecord player : allPlayers) {
				if (maxHomeRuns == Double.parseDouble(player.getHR())) {
					playerMaxHR = player;
				}
			}
			System.out.println("\n");
			System.out.println("The player that hit the max home runs at " +maxHomeRuns +": " +playerMaxHR);		


			// number of players with at least 10 At-Bats
			int playersTenAB = 0; 	// initialise player counter
			double highestSLG = 0;	// initialise highest slugging percentage
			PlayerRecord playerHighestSLG = null; //initialise player with highest SLG


			for (String team: teamDatabase.keySet()) {
				ArrayList<PlayerRecord> teamPlayerList = new ArrayList<>(); // ArrayList will hold all players in a certain team
				teamPlayerList = teamDatabase.get(team); // get all players in team

				// loop counts player who hit at least 10 At-Bats
				for (PlayerRecord player : teamPlayerList) {
					if (Double.parseDouble(player.getAB()) >= 10) {
						playersTenAB = playersTenAB + 1;
						if (Double.parseDouble(player.getSLG()) > highestSLG) {
							highestSLG = Double.parseDouble(player.getSLG());
							playerHighestSLG = player;
						}
					}
				}
				System.out.println("\n\n");
				System.out.println("The number of players in the team " +team +" who hit at least 10 At-Bats: " +playersTenAB );
				System.out.println("From these players, the one with the highest slugging percentage: "+ playerHighestSLG);
				highestSLG = 0;	// reset highest SLG
				playersTenAB = 0; // reset number of players in team with at least 10 at-bats
			}

		}

		catch (IOException e) {e.printStackTrace();}

		
// THIS IS THE CODE THAT SIMON EMAILED TO EVERYONE //
		
//		// Create HashMap of ArrayLists to store Batter data using team as key
//		HashMap<String, ArrayList<Batter>> sortedBatters = new HashMap<String, ArrayList<Batter>>();
//
//		// Loop over complete Batter list
//		for (Batter player : batterList) {
//
//			// Retrieve team for that Batter
//			String curTeam = player.getTeam();
//
//			// Extract Batter list from HashMap using this team
//			ArrayList<Batter> thisBatterList = sortedBatters.get(curTeam);
//
//			// If this list is empty, create a new ArrayList of Batters
//			if (thisBatterList == null) {
//				sortedBatters.put(curTeam, new ArrayList<Batter>());
//			}
//
//			// Add current Batter to list of Batters for that team
//			sortedBatters.get(curTeam).add(player);
//
//		}

	}

}
