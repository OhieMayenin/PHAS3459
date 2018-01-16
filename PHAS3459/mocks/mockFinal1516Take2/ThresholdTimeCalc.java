package mockFinal1516Take2;

public class ThresholdTimeCalc implements ArrivalTimeCalculator {
	double threshold;

	public ThresholdTimeCalc (double threshold) {
		this.threshold = threshold;
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
