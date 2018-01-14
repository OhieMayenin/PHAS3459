package mockFinal1314;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Mock1314MainPt3 {
	static HashMap<String,String> speciesDatabase;
	
	public static void main(String[] args) {
		String animalSpeciesURL = "species-animals.txt";
		String animalSurveyURL = "survey-animals.txt";
		DataReader dr = new DataReader("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/");
		
		try {
		speciesDatabase = dr.extractSpecies(animalSpeciesURL);
		
		ArrayList<Animal> allAnimals = dr.readAnimalURL(animalSurveyURL);
		HashMap<String,ArrayList<Animal>> surveyDatabase = dr.sortAnimal(allAnimals);
		System.out.println(surveyDatabase);
		System.out.println("\n");
		
		}
		catch (IOException e) {e.printStackTrace();}
		}
	}

}
