package mockFinal1314;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Mock1314MainPt1 {
	static HashMap<String,String> speciesDatabase;
	
	public static void main(String[] args) {
		String plantSpeciesURL = "species-plants.txt";
		String plantSurveyURL = "survey-plants.txt";
		DataReader dr = new DataReader("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/");
		
		try {
			speciesDatabase = dr.extractSpecies(plantSpeciesURL);
			System.out.println(speciesDatabase);
			
			ArrayList<Plant> allPlants = dr.readURL(plantSurveyURL);
			HashMap<String,ArrayList<Plant>> surveyDatabase = dr.sort(allPlants);
			System.out.println(surveyDatabase);
			System.out.println("\n");
			
			// UNPACKING AND HARDCODE SORTING DONE IN 30 MINUTES
			
			presentBySpecies(surveyDatabase); // print statistics for each species
			
			// PART 1 COMPLETE IN 1 HOUR
			// PART 2
			
			try {
			// implementing latitude filter and calculating mean height
			ArrayList<Plant> filtered = filterNorth(surveyDatabase);
			double meanNorth = calculateMean(filtered);
			System.out.println("\n" +"Mean Height of Northern Species: " +meanNorth);
			ArrayList<Plant> filteredS = filterSouth(surveyDatabase);
			double meanSouth = calculateMean(filteredS);
			System.out.println("\n" +"Mean Height of Southern Species: " +meanSouth);
			}
			catch (Exception e) {e.printStackTrace();}
			
			try {
			// implementing distance filter and calculating mean height
			ArrayList<Plant> filterMountain = filterDistance(surveyDatabase);
			double meanMountain = calculateMean(filterMountain);
			System.out.println("\n" +"Mean Height of Specimens within 50km of mountain summit: " +meanMountain);
			}
			catch (Exception e) {e.printStackTrace();}
		}
		catch (IOException e) {e.printStackTrace();} 

	
	}
	
	/*
	 * takes argument of HashMap of survey data
	 * presents species name, number of specimens found and mean height
	 */
	public static void presentBySpecies(HashMap<String, ArrayList<Plant>> survey) {
		Collection<String> allSpecies = speciesDatabase.keySet();
		double mean;
		double maxMean = 0;
		String maxMeanSpecies = "";
		double minMean = Double.MAX_VALUE;
		String minMeanSpecies = "";
		
		for (String species : allSpecies) {
			ArrayList<Plant> listOfSpecies = survey.get(species);
			mean = calculateMean(listOfSpecies);
			
			if (mean > maxMean) {
				maxMean = mean;
				maxMeanSpecies = listOfSpecies.get(0).name;
			}
			if (mean < minMean) {
				minMean = mean;
				minMeanSpecies = listOfSpecies.get(0).name;
			}
						
			System.out.println("\n" +"Species:" +listOfSpecies.get(0).name +"("+listOfSpecies.get(0).code +")" 
			+"\n" +"Number of Specimens Found: " +listOfSpecies.size() +"\n" +"Mean Height: " +mean);
			
		}
		System.out.println("\n" +"Species with the highest mean at " +maxMean +": " +"\n" +maxMeanSpecies);
		System.out.println("Species with the lowest mean at " +minMean +": " +"\n" +minMeanSpecies);
	}
	
	/*
	 * calculates mean height for each species
	 */
	public static double calculateMean(ArrayList<Plant> species) {
		double sum = 0;
		
		for (Plant plant : species) {
		sum += Double.parseDouble(plant.height);
		}
		
		double mean = sum/species.size();
		return mean;
	}
	
	public static ArrayList<Plant> filterNorth(HashMap<String,ArrayList<Plant>> surveyDatabase) throws Exception {
		LatitudeFilter lf = new LatitudeFilter(0,-30); // north of -30
		ArrayList<Plant> northSpecimens = lf.filter(surveyDatabase.get("NT"));
		//System.out.println(northSpecimens);
	
		return northSpecimens;
	}
	
	public static ArrayList<Plant> filterSouth(HashMap<String,ArrayList<Plant>> surveyDatabase) throws Exception {
		LatitudeFilter lf2 = new LatitudeFilter(-30,-100); // south of -30
		ArrayList<Plant> southSpecimens = lf2.filter(surveyDatabase.get("NT"));
		//System.out.println(southSpecimens);
	
		return southSpecimens;
	}
	
	public static ArrayList<Plant> filterDistance(HashMap<String,ArrayList<Plant>> surveyDatabase) throws Exception {
		DistanceFilter df = new DistanceFilter(50, -30.967, 75.430);
		ArrayList<Plant> filtered = df.filter(surveyDatabase.get("BN"));
		
		return filtered;
	}
}
