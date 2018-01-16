package mockFinal1314;

import java.util.ArrayList;

public class LatitudeFilter implements SpecimenFilter {
	double maxLatitude;
	double minLatitude;
	
	public LatitudeFilter(double maxLatitude, double minLatitude) throws Exception {
		this.maxLatitude = maxLatitude;
		this.minLatitude = minLatitude;
		
		if (maxLatitude <= minLatitude) {
			throw new Exception ("ERROR: Maximum latitude cannot be smaller or equal to minimum latitude.");
		}
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see mockFinal1314.SpecimenFilter#filteredSpecimens(java.util.ArrayList)
	 * filters specimens and returns list of those found between
	 * given min and max latitude
	 */
	public ArrayList<Plant> filter(ArrayList<Plant> allSpecimens) {
		ArrayList<Plant> plantsInRegion = new ArrayList<Plant>();
		
		for (Plant plant : allSpecimens) {
			if (Double.parseDouble(plant.latitude) < maxLatitude && 
					Double.parseDouble(plant.latitude) > minLatitude) {
				plantsInRegion.add(plant);
			}
		}
		
		return plantsInRegion;
	}

}
