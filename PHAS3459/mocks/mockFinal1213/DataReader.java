package mockFinal1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataReader {
	String urlMain;

	/*
	 * constructor sets umbrella URL name
	 */
	public DataReader(String urlName) {
		this.urlMain = urlName;
	}


	public ArrayList<EnergyBin> readURL(String urlName, String channel) throws IOException {
		String line = "";


		ArrayList<EnergyBin> bins = new ArrayList<EnergyBin>();

		URL u = new URL(urlMain+urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory


		// parse each line and instantiate EnergyBin object
		while ((line = url.readLine()) != null) {
			EnergyBin bin = parseLine(line, channel);

			if (bin.low.equals("Min")) {bin = null;} // skip first line
			else {bins.add(bin);} // add new EnergyBin object to ArrayList
		}

		return bins;
	}

	/*
	 * parses a line from the url file
	 * channel must be inputed as either "GG" or "ZZ"
	 * returns a EnergyBin object representing data from that line
	 */
	public static EnergyBin parseLine(String line, String channel) {
		String min;
		String max;
		String events;

		Scanner s2 = new Scanner(line);
		min = s2.next();
		max = s2.next();
		events = s2.next();

		EnergyBin bin = new EnergyBin(channel, min, max, events);

		s2.close();

		return bin;
	}

	public static Higgs parseLineHiggs(String line) {
		String channel;
		String energy;

		Scanner s2 = new Scanner(line);
		channel = s2.next();
		energy = s2.next();

		Higgs higgs = new Higgs(channel, energy);

		s2.close();

		return higgs;
	}

	public static HashMap<String, ArrayList<EnergyBin>> sort(ArrayList<EnergyBin> input1, ArrayList<EnergyBin> input2) {
		HashMap<String, ArrayList<EnergyBin>> binDatabase = new HashMap<String, ArrayList<EnergyBin>>();

		if (input1.get(0).channel.equals("GG")) {
			binDatabase.put("GG", input1);
		}	
		else {binDatabase.put("ZZ", input1);}

		if (input2.get(0).channel.equals("GG")) {
			binDatabase.put("GG", input2);
		}
		else {binDatabase.put("ZZ", input2);}

		return binDatabase;
	}

	public ArrayList<Higgs> readHiggs(String urlName) throws IOException {
		ArrayList<Higgs> allHiggs = new ArrayList<Higgs>();

		String line = "";

		URL u = new URL(urlMain+urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory


		// parse each line and instantiate EnergyBin object
		while ((line = url.readLine()) != null) {
			Higgs higgs = parseLineHiggs(line);
			if (higgs.channel.equals("Channel")) {higgs = null;} // skip first line
			else {allHiggs.add(higgs);} // add new Higgs object to ArrayList
		}

		return allHiggs;
	}

	public HashMap<String, ArrayList<Higgs>> sortHiggs (ArrayList<Higgs> allHiggs, HashMap<String, ArrayList<EnergyBin>> binDatabase) {
		HashMap<String, ArrayList<Higgs>> sortedHiggs = new HashMap<String, ArrayList<Higgs>>();
		double maxE;
		double minE;
		ArrayList<Higgs> higgsInBin;

		// GG and ZZ have same bins, so GG chosen at random
		for (EnergyBin bin : binDatabase.get("GG")) {
			minE = Double.parseDouble(bin.low); // get max and min energies of each bin
			maxE = Double.parseDouble(bin.high);

			higgsInBin = new ArrayList<Higgs>(); // to hold Higgs in each bin
			String binEnergy = "" +minE +"-" +maxE; // key of hashmap

			// add higgs to arraylist if it is inside the bin
			for (Higgs higgs : allHiggs) {
				if (Double.parseDouble(higgs.energy) < maxE && Double.parseDouble(higgs.energy) >= minE) {
					higgsInBin.add(higgs);
				}
			}
			sortedHiggs.put(binEnergy, higgsInBin);
		}

		return sortedHiggs;
	}

}
