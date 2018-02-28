package mockFinal1415;

import java.util.ArrayList;

public class MeanCalculator implements SeaLevelCalculator {

	@Override
	public double run(ArrayList<Tide> tides) {
		
		double sum = 0;
		int size = tides.size();
		
		for (Tide tide : tides) {
			sum += Double.parseDouble(tide.seaLevel);
		}
		double mean = sum/size;
		return mean;
	}
	

}
