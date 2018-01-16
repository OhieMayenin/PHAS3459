package mockFinal1314;

import java.util.ArrayList;

public class DistanceFilter implements SpecimenFilter{
	double distance;
	double longitude;
	double latitude;
	double radius = 6371; // km
	
	/*
	 * constructor defines max distance
	 * and latitude and longitude
	 * of point to set as centre
	 */
	public DistanceFilter (double distance, double latitude, double longitude) throws Exception {
		this.distance = distance;
		this.latitude = latitude;
		this.longitude = longitude;
		
		if (distance <= 0) {
			throw new Exception ("Distance must be a positive, non-zero value");
		}
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see mockFinal1314.SpecimenFilter#filteredSpecimens(java.util.ArrayList)
	 * filters specimens and returns list of those found within
	 * a specified distance from a given point
	 */
	public ArrayList<Plant> filter(ArrayList<Plant> allSpecimens) {
		ArrayList<Plant> withinDistance = new ArrayList<Plant>();
		
		for (Plant plant : allSpecimens) {
			double latitudePlant= Double.parseDouble(plant.latitude);
			double longitudePlant = Double.parseDouble(plant.longitude);
			
			double maxLat = Math.sin(distance/radius);
			double maxLong = Math.sin(distance/radius);
			
			if (latitudePlant < latitude+maxLat && longitudePlant < longitude+maxLong) {
				withinDistance.add(plant);
			}
		}
		return withinDistance;
	}
	
	public ArrayList<Animal> filterAnimals(ArrayList<Animal> allSpecimens) {
		ArrayList<Animal> withinDistance = new ArrayList<Animal>();
		
		for (Animal animal : allSpecimens) {
			double latitudeAnimal= Double.parseDouble(animal.latitude);
			double longitudeAnimal = Double.parseDouble(animal.longitude);
			
			double maxLat = Math.sin(distance/radius);
			double maxLong = Math.sin(distance/radius);
			
			if (latitudeAnimal < latitude+maxLat && longitudeAnimal < longitude+maxLong) {
				withinDistance.add(animal);
			}
		}
		return withinDistance;
	}
	
	public ArrayList<Animal> animalsOutsideDistance(ArrayList<Animal> allSpecimens) {
		ArrayList<Animal> outsideDistance = new ArrayList<Animal>();
		
		for (Animal animal : allSpecimens) {
			double latitudeAnimal= Double.parseDouble(animal.latitude);
			double longitudeAnimal = Double.parseDouble(animal.longitude);
			
			double maxLat = Math.sin(distance/radius);
			double maxLong = Math.sin(distance/radius);
			
			if (latitudeAnimal > latitude+maxLat || longitudeAnimal > longitude+maxLong) {
				outsideDistance.add(animal);
			}
		}
		return outsideDistance;
	}
}
