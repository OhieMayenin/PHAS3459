package mockFinal1314;

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
	
	public HashMap<String,ArrayList<Plant>> sort(ArrayList<Plant> plants) {
		HashMap<String,ArrayList<Plant>> database = new HashMap<String,ArrayList<Plant>>();
		ArrayList<Plant> FT = new ArrayList<Plant>();
		ArrayList<Plant> TT = new ArrayList<Plant>();
		ArrayList<Plant> CC = new ArrayList<Plant>();
		ArrayList<Plant> SG = new ArrayList<Plant>();
		ArrayList<Plant> NT = new ArrayList<Plant>();
		ArrayList<Plant> BN = new ArrayList<Plant>();
		
		for (Plant plant : plants) {
			if (plant.code.equals("FT")) {
				FT.add(plant);
			}
			if (plant.code.equals("TT")) {
				TT.add(plant);
			}
			if (plant.code.equals("CC")) {
				CC.add(plant);
			}
			if (plant.code.equals("SG")) {
				SG.add(plant);
			}
			if (plant.code.equals("NT")) {
				NT.add(plant);
			}
			if (plant.code.equals("BN")) {
				BN.add(plant);
			}
		}
		database.put(FT.get(0).code, FT);
		database.put(TT.get(0).code, TT);
		database.put(CC.get(0).code, CC);
		database.put(SG.get(0).code, SG);
		database.put(NT.get(0).code, NT);
		database.put(BN.get(0).code, BN);
		
		return database;
	}
	
	
	public ArrayList<Plant> readURL(String urlName) throws IOException {
		String line = "";
		
		
		ArrayList<Plant> plants = new ArrayList<Plant>();
		
		URL u = new URL(urlMain+urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		
		
		// parse each line and instantiate Plant object
		while ((line = url.readLine()) != null) {
			Plant plant = parseLine(line);
			plants.add(plant); // add new Plant object to ArrayList
			}
		
		return plants;
	}
	
	public static Plant parseLine(String line) {
		String latitude;
		String longitude;
		String code;
		String height;
		
		Scanner s2 = new Scanner(line);
		latitude = s2.next();
		longitude = s2.next();
		code = s2.next();
		height = s2.next();
		
//		StringBuilder date = new StringBuilder();
//		date.append(day +"/" +month +"/" +year);
//		StringBuilder time = new StringBuilder();
//		time.append(hour +":" +minute);
		
		Plant plant = new Plant(latitude.toString(), longitude.toString(), code.toString(), height.toString());
		
		s2.close();
				
		return plant;
	}
	
	public HashMap<String,String> extractSpecies(String urlSites) throws IOException {
		HashMap<String,String> species = new HashMap<String,String>(); // key is code, value is scientifc name
		
		URL u = new URL(urlMain+urlSites); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url);
		
		String code = "";
		String name1 = "";
		String name2 = "";
		String fullName = "";
		
		while (s.hasNext()) {
			code = s.next();
			name1 = s.next();
			name2 = s.next();
			fullName = name1 +" " +name2;
			
			species.put(code, fullName);
		}
		
		return species;
	}
	
	
	// PT3 METHODS
	
	public HashMap<String,ArrayList<Animal>> sortAnimals(ArrayList<Animal> animals) {
		HashMap<String,ArrayList<Animal>> database = new HashMap<String,ArrayList<Animal>>();
	
		for (Animal animal : animals) {
			String key = animal.code;
			
			if (database.get(key) == null) {
				ArrayList<Animal> species = new ArrayList<Animal>();
				database.put(key, species);
			}
			
			database.get(key).add(animal);
			}
		
		return database;
	}
	
	
	/*
	 * same method as readURL but for animals
	 */
	public ArrayList<Animal> readAnimalURL(String urlName) throws IOException {
		String line = "";
		
		
		ArrayList<Animal> animals = new ArrayList<Animal>();
		
		URL u = new URL(urlMain+urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		
		
		// parse each line and instantiate Animal object
		while ((line = url.readLine()) != null) {
			Animal animal = parseAnimalLine(line);
			animals.add(animal); // add new Animal object to ArrayList
			}
		
		return animals;
	}
	
	/*
	 * parseLine method for animal data
	 */
	public static Animal parseAnimalLine(String line) {
		String latitude;
		String longitude;
		String code;
		
		Scanner s2 = new Scanner(line);
		latitude = s2.next();
		longitude = s2.next();
		code = s2.next();
		
//		StringBuilder date = new StringBuilder();
//		date.append(day +"/" +month +"/" +year);
//		StringBuilder time = new StringBuilder();
//		time.append(hour +":" +minute);
		
		Animal animal = new Animal(latitude.toString(), longitude.toString(), code.toString());
		
		s2.close();
				
		return animal;
	}
	

	
}
