package module6;

import java.util.ArrayList;

public interface GoodnessOfFitCalculator {
	static double goodnessOfFit(Theory theoretical, ArrayList<DataPoint> dataPoints) {
		double chiSq = ChiSquared.goodnessOfFit(theoretical, dataPoints);
		
	}
	}
