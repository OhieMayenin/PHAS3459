package mockFinal1314;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Mock1314MainPt3 {
	static HashMap<String,String> speciesDatabase;
	static HashMap<String, ArrayList<Animal>> surveyDatabase;

	public static void main(String[] args) {
		String animalSpeciesURL = "species-animals.txt";
		String animalSurveyURL = "survey-animals.txt";
		DataReader dr = new DataReader("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/");

		try {
			speciesDatabase = dr.extractSpecies(animalSpeciesURL);
			System.out.println(speciesDatabase);

			ArrayList<Animal> allAnimals = dr.readAnimalURL(animalSurveyURL);
			surveyDatabase = dr.sortAnimals(allAnimals);
			//			System.out.println(surveyDatabase);
			System.out.println("\n");	
		}
		catch (IOException e) {e.printStackTrace();}

		try {
			distanceFiltering(surveyDatabase);
		}
		catch (Exception e) {e.printStackTrace();}
	}


	public static void distanceFiltering (HashMap<String,ArrayList<Animal>> surveyDatabase) throws Exception {
		// distance filtering 100km from mountain summit
		DistanceFilter df = new DistanceFilter(100, -30.967, 75.430);
		Collection<ArrayList<Animal>> allSpecies = surveyDatabase.values();

		ArrayList<Animal> withinRange = new ArrayList<Animal>();
		ArrayList<Animal> outsideRange = new ArrayList<Animal>();
		ArrayList<ArrayList<Animal>> withinCollection = new ArrayList<ArrayList<Animal>>();
		ArrayList<ArrayList<Animal>> outsideCollection = new ArrayList<ArrayList<Animal>>();

		for (ArrayList<Animal> species : allSpecies) {
			withinRange = df.filterAnimals(species);
			outsideRange = df.animalsOutsideDistance(species);
			withinCollection.add(withinRange);
			outsideCollection.add(outsideRange);
		}

		// merge all arraylists with arraylists into one super arraylist


		for (Iterator<Animal> it = withinRange.iterator(); it.hasNext();) {
			Animal animal = it.next();
			for (Animal animal2 : outsideRange) {
				if (animal.code.equals(animal2.code)) {
					it.remove();
					break;
				}
			}
		}
		//System.out.println(withinRange);
		System.out.println("The number of animal species exclusively found within 100km from the mountain summit: " +withinRange.size());
	}
}

