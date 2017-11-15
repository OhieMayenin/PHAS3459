/**
 * This class defines a PlayerRecord object to hold player information read from the URL
 */

package mockExam;

import java.util.ArrayList;

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
	String OBP;		// fraction of times player managed to reach base through any (legal) means
	
	
	/*
	 * constructor for the object PlayerRecord
	 * ArrayList playerData is to contain all the data concerning a certain player
	 * playerData will contain data elements in the following order:
	 * <team, pos, G, AB, R, H, twoB, threeB, HR, RBI, AVG, OBP>
	 */
	public PlayerRecord (ArrayList<String> input) {
		//this.keyName=  input.get(0);
		this.team = input.get(0);
		this.pos = input.get(1);
		this.G = input.get(2);
		this.AB = input.get(3);
		this.R = input.get(4);
		this.H = input.get(5);
		this.twoB = input.get(6);
		this.threeB = input.get(7);
		this.HR = input.get(8);
		this.RBI = input.get(9);
		this.AVG = input.get(10);
		this.OBP  = input.get(11);
		// this string array is for referencing the order of the elements in the following for loop
		// for loop sets all data variables to the input ArrayList values
			
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
	
	
	
}
