package mockFinal1415;

import java.util.ArrayList;

public class TidalRangeCalculator implements SeaLevelCalculator {

	@Override
	/*
	 * (non-Javadoc)
	 * @see mockFinal1415.SeaLevelCalculator#run(java.util.ArrayList)
	 * calculates difference between 
	 * max. and min. sea level in ArrayList of tides
	 */
	public double run(ArrayList<Tide> tides) {
		double range;
		double maxTide = 0;
		double minTide = Double.MAX_VALUE;
		
		for (Tide tide : tides) {
			if (Double.parseDouble(tide.seaLevel) > maxTide) {
				maxTide = Double.parseDouble(tide.seaLevel);
			}
			
			if (Double.parseDouble(tide.seaLevel) < minTide) {
				minTide = Double.parseDouble(tide.seaLevel);
			}
		}
		range = maxTide - minTide;	
		
		return range;
	}

}
