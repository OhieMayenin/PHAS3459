/**
 * This class defines a PlayerRecord object to hold player information read from the URL
 */

package mockExam;

import java.util.ArrayList; // import classes
import java.util.Scanner;

public class PlayerRecord {

	String keyName;	// Hash Key: name of player

	// data fields belonging to each player name
	String team;	// team of player
	String pos;		// position of player
	String G;		// number of games
	String AB;		// total number of at-bats
	String R;		// total number of runs
	String H;		// number of times 1st base reached from hit
	String twoB;	// number of times 2nd base reached from hit
	String threeB;	// number of times 3rd base reached from hit
	String HR;		// number of home runs
	String RBI;		// runs batted in: number of runs scored due to batter's action
	String AVG;		// batting average: AVG = H/AB
	String OBP;		// on-base percentage: fraction of times player managed to reach base through any (legal) means
	String SLG; 	// slugging percentage: total number of bases \div at bats
	String OPS;		// on-base plus slugging figure: OBP + SLG

	/*
	 * constructor for the object PlayerRecord
	 * ArrayList playerData is to contain all the data concerning a certain player
	 * playerData will contain data elements in the following order:
	 * <team, pos, G, AB, R, H, twoB, threeB, HR, RBI, AVG, OBP, SLG, 0PS>
	 */
	public PlayerRecord (ArrayList<String> input) {
		// setting all the values defined above to the elements of the input ArrayList
		this.keyName=  input.get(0);
		this.team = input.get(1);
		this.pos = input.get(2);
		this.G = input.get(3);
		this.AB = input.get(4);
		this.R = input.get(5);
		this.H = input.get(6);
		this.twoB = input.get(7);
		this.threeB = input.get(8);
		this.HR = input.get(9);
		this.RBI = input.get(10);
		this.AVG = input.get(11);
		this.OBP  = input.get(12);
		this.SLG = input.get(13);
		this.OPS = input.get(14);
			}



	/*
	 * method takes a line of the URL document and returns a PlayerRecord object for that line, representing one player
	 */
	public static PlayerRecord parseLine(String line) {
		Scanner s = new Scanner(line).useDelimiter("\t"); // uses tab as delimiter for scanner
		ArrayList<String> player = new ArrayList<String>();
		int i = 0; // iterator
		int max = 13;

		for (i = 0; i < max; i++) {
			player.add(s.next());	
		}


		// calculate SLG unless at-bats is 0, in which case SLG is undefined
		// relevant indices: 3- AB, 5-H, 6-twoB, 7-threeB, 8-HR
		if (Double.parseDouble(player.get(3)) != 0) {

			double slg = (Double.parseDouble(player.get(5)) + (2*Double.parseDouble(player.get(6))) + (3*Double.parseDouble(player.get(7))) + (4*Double.parseDouble(player.get(8))))/Double.parseDouble(player.get(3)); //in doubles
			String playerSLG = ""+slg; // convert to string	
			player.add(playerSLG);
		} 

		else {
			String playerSLG = "0";
			player.add(playerSLG);
		}

		// 0PS = 0BP + SLG 
		double ops = Double.parseDouble(player.get(11)) + Double.parseDouble(player.get(12));
		String playerOPS = ""+ops; ;   // convert to string

		player.add(playerOPS);

		PlayerRecord playerRecord = new PlayerRecord(player); // instantiate new PlayerRecord object

		return playerRecord;

	}

	// method sets string format for PlayerRecord objects
	public String toString() {
		String strFirst = "Player Name: " +keyName +", " +"Team: " +team +", " +"Position: " +pos; 
		String strSecond = "Games Played: " +G +", " +"At-bats: " +AB +", " +"Runs: " +R  +", Hits: " +H;
		String strThird = "Doubles: " +twoB +", Triples: " +threeB +", Home Runs: " +HR; 
		String strFourth = "Runs Batted In: "+ RBI +", Batting Average: " +AVG + ", On-Base Percentage: " +OBP;
		String strFifth = "Slugging Percentage: "+SLG + ", On-Base Plus Slugging Figure: " + OPS;

		String strAll = "\n" +"\n" +strFirst + "\n" + strSecond +"\n" + strThird + "\n" + strFourth+ "\n"+ strFifth;

		return strAll;
	}

	// defining all getter methods to retrieve PlayerRecord data elements

	public String getTeam() {
		return this.team;
	}

	public String getPos() {
		return this.pos;
	}

	public String getG() {
		return this.G;
	}

	public String getAB() {
		return this.AB;
	}

	public String getR() {
		return this.R;
	}

	public String getH() {
		return this.H;
	}

	public String getTwoB() {
		return this.twoB;
	}

	public String getThreeB() {
		return this.threeB;
	}

	public String getHR() {
		return this.HR;
	}

	public String getRBI() {
		return this.RBI;
	}

	public String getAVG() {
		return this.AVG;
	}

	public String getOBP() {
		return this.OBP;
	}
	
	public String getSLG() {
		return this.SLG;
	}
	
	public String getOPS() {
		return this.OPS;
	}



}
