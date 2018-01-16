package mockFinal1516Take2;

public class ThresholdTimeCalc implements ArrivalTimeCalculator {
	double threshold;

	public ThresholdTimeCalc (double threshold) throws Exception {
		this.threshold = threshold;
		
		if (threshold <= 0) {
			throw new Exception("Threshold value must be positive and non-zero.");
		}
	}

	@Override
	public int run(Pulse p) {
		int arrivalTime = 0;
		int count = -1;
		
		for (double signal : p.pulse) {
			count++;
			if (signal >= 1) {
				arrivalTime = count;
			}
		}
		
		return arrivalTime;
	}

}
