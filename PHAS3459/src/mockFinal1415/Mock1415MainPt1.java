package mockFinal1415;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Mock1415MainPt1 {

	public static void main(String[] args) {
		String url1999 = "tides-1999.txt"; // files found on main URL
		String url2000 = "tides-2000.txt";
		String url2001 = "tides-2001.txt";
		String sites = "sites.txt";
		DataReader dr = new DataReader("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/"); // set main/umbrella URL name

		try {

			HashMap<String,String> sitesDatabase = dr.extractSites(sites); // extract data from sites.txt, store in hash map
			System.out.println(sitesDatabase);
			
			// extract data from tides.txt files, store in ArrayLists of Tide objects
			ArrayList<Tide> y99 = dr.readURL(url1999); 
			ArrayList<Tide> y00 = dr.readURL(url2000);
			ArrayList<Tide> y01 = dr.readURL(url2001);
			
			HashMap<String,ArrayList<Tide>> tideDatabase = dr.sort(y99,y00,y01); // sort into hash map

			// All unpacking and formatting done after 45 minutes //

			System.out.println(tideDatabase.keySet());

			// implementing SeaLevelCalculator interface for part 2 
			findGreatestLevel(tideDatabase, sitesDatabase); // finding greatest sea level measurement
			calculateMean(tideDatabase, sitesDatabase); // calculate mean by location
			calculateTidalRange(tideDatabase, sitesDatabase); // calculate tidal ranges by location

			// PART 3
			findLargestSurge(tideDatabase, sitesDatabase); // finds largest tidal surge
			
			
			// NOW REUSING CODE TO READ NEW FILES FOR 2004, 2005, 2006 //
			String url2004 = "tides-2004.txt"; // files to be read in part 3
			String url2005 = "tides-2005.txt";
			String url2006 = "tides-2006.txt";
			//String sites2 = "sites.txt"; 
			DataReader dr2 = new DataReader("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/"); // new umbrella url to read from folder "part 3"
			
			HashMap<String,String> sitesDatabase2 = dr2.extractSites(sites); // extract data from new sites.txt
			System.out.println(sitesDatabase2);
			
			// extract data from new tides.txt files, store in ArrayLists of Tide objects
			ArrayList<Tide> y04 = dr2.readURLPt3(url2004);
			ArrayList<Tide> y05 = dr2.readURLPt3(url2005);
			ArrayList<Tide> y06 = dr2.readURLPt3(url2006);

			HashMap<String,ArrayList<Tide>> tideDatabase2 = dr2.sort(y04,y05,y06); // sort into hash map
			
			findLargestSurge(tideDatabase2, sitesDatabase2); // finds largest tidal surge
		}
		catch (IOException e) {e.printStackTrace();}
	}

	/*
	 * finds greatest sea level measured
	 */
	public static void findGreatestLevel (HashMap<String,ArrayList<Tide>> tideDatabase, HashMap<String,String> sitesDatabase) {
		// initialise all variables related to tide with max level
		double maxTide = 0; 
		String maxTideDate = "";
		String maxTideLoc = "";
		String maxTideTime = "";
		
		// loop finds tide with max sea level
		for (String year : tideDatabase.keySet()) {
			ArrayList<Tide> tides = tideDatabase.get(year);

			for (Tide tide : tides) {
				if (Double.parseDouble(tide.seaLevel) > maxTide) {
					maxTide = Double.parseDouble(tide.seaLevel);
					maxTideDate = tide.date;
					maxTideLoc = tide.loc;
					maxTideTime = tide.time;
				}
			}
		}
		String maxTideLocName = sitesDatabase.get(maxTideLoc);
		System.out.println("Highest observed level taken at: " +maxTideLocName +"(" +maxTideLoc +")"  +"\n" 
				+"where the measured sea level was: " +maxTide +" on " +maxTideDate +" at " +maxTideTime);
	}

	/*
	 * sorts tides by location
	 * and then calculates mean for each location
	 */
	public static void calculateMean (HashMap<String,ArrayList<Tide>> tideDatabase, HashMap<String,String> sitesDatabase) {
		MeanCalculator mc = new MeanCalculator(); 	// calculate mean

		// extract values from hash map
		Collection<ArrayList<Tide>> allTides = tideDatabase.values();

		// new arraylists to hold tides by location
		ArrayList<Tide> aberdeen = new ArrayList<Tide>();
		ArrayList<Tide> dover = new ArrayList<Tide>();
		ArrayList<Tide> liverpool = new ArrayList<Tide>();
		ArrayList<Tide> wick = new ArrayList<Tide>();
		ArrayList<Tide> bournemouth = new ArrayList<Tide>();

		// sort by location
		for (ArrayList<Tide> tides : allTides) {
			for (Tide tide : tides) {
				if (sitesDatabase.get(tide.loc).equals("Aberdeen")) {
					aberdeen.add(tide);
				}
				if (sitesDatabase.get(tide.loc).equals("Dover")) {
					dover.add(tide);
				}
				if (sitesDatabase.get(tide.loc).equals("Liverpool")) {
					liverpool.add(tide);
				}
				if (sitesDatabase.get(tide.loc).equals("Wick")) {
					wick.add(tide);
				}
				if (sitesDatabase.get(tide.loc).equals("Bournemouth")) {
					bournemouth.add(tide);
				}

			}

		}
		// calculate means for each location and print to console
		double meanAberdeen = mc.run(aberdeen);
		double meanDover = mc.run(dover);
		double meanLiverpool = mc.run(liverpool);
		double meanWick = mc.run(wick);
		double meanBournemouth = mc.run(bournemouth);
		System.out.println("\n");
		System.out.println("The mean sea level of the data from Aberdeen is: " +meanAberdeen+" m");
		System.out.println("The mean sea level of the data from Dover is: " +meanDover+" m");
		System.out.println("The mean sea level of the data from Liverpool is: " +meanLiverpool+" m");
		System.out.println("The mean sea level of the data from Wick is: " +meanWick+" m");
		System.out.println("The mean sea level of the data from Bournemouth is: " +meanBournemouth+" m");


	}

	/*
	 * sorts tides by location
	 * finds tidal range for each location
	 */
	public static void calculateTidalRange (HashMap<String,ArrayList<Tide>> tideDatabase, HashMap<String,String> sitesDatabase) {
		TidalRangeCalculator trc = new TidalRangeCalculator(); // calculate tidal range

		Collection<ArrayList<Tide>> allTides = tideDatabase.values(); // get values from hash map

		// new arraylists to hold tides by location
		ArrayList<Tide> aberdeen = new ArrayList<Tide>();
		ArrayList<Tide> dover = new ArrayList<Tide>();
		ArrayList<Tide> liverpool = new ArrayList<Tide>();
		ArrayList<Tide> wick = new ArrayList<Tide>();
		ArrayList<Tide> bournemouth = new ArrayList<Tide>();

		// sort by location
		for (ArrayList<Tide> tides : allTides) {
			for (Tide tide : tides) {
				if (sitesDatabase.get(tide.loc).equals("Aberdeen")) {
					aberdeen.add(tide);
				}
				if (sitesDatabase.get(tide.loc).equals("Dover")) {
					dover.add(tide);
				}
				if (sitesDatabase.get(tide.loc).equals("Liverpool")) {
					liverpool.add(tide);
				}
				if (sitesDatabase.get(tide.loc).equals("Wick")) {
					wick.add(tide);
				}
				if (sitesDatabase.get(tide.loc).equals("Bournemouth")) {
					bournemouth.add(tide);
				}

			}
		}
		
		// calculate tidal ranges for each location
		double tidalRangeAberdeen = trc.run(aberdeen);
		double tidalRangeDover = trc.run(dover);
		double tidalRangeLiverpool = trc.run(liverpool);
		double tidalRangeWick = trc.run(wick);
		double tidalRangeBournemouth = trc.run(bournemouth);

		System.out.println("\n");
		System.out.println("The tidal range at Aberdeen is: " +tidalRangeAberdeen +" m");
		System.out.println("The tidal range at Dover is: " +tidalRangeDover+" m");
		System.out.println("The tidal range at Liverpool is: " +tidalRangeLiverpool+" m");
		System.out.println("The tidal range at Wick is: " +tidalRangeWick+" m");
		System.out.println("The tidal range at Bournemouth is: " +tidalRangeBournemouth+" m");

	}

	/*
	 * finds largest tidal surge
	 * from all tide objects in hash map
	 */
	public static void findLargestSurge(HashMap<String,ArrayList<Tide>> tideDatabase, HashMap<String,String> sitesDatabase) {
		Collection <ArrayList<Tide>> allTides = tideDatabase.values();
		double maxSurge = 0;
		Tide maxTide = null;

		// loop finds largest tidal surge from an ArrayList of Tide objects
		for (ArrayList<Tide> tides : allTides) {
			for (Tide tide : tides) {
				double surge = calculateTidalSurge(tide);
				if (surge > maxSurge) {
					maxSurge = surge;
					maxTide = tide;
				}
			}
		}

		System.out.println("\n" +"The largest tidal surge was calculated to be: " +maxSurge +" m"
				+"\n" +"The details of this measurement are: " +maxTide);
	}

	/*
	 * calculate tidal surge for
	 * one tide object
	 */
	public static double calculateTidalSurge(Tide tide) {
		double tidalSurge = Double.parseDouble(tide.seaLevel) - Double.parseDouble(tide.predicted);
		return tidalSurge;
	}
}
