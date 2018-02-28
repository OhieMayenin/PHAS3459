/**
 * implements ArrivalTimeCalculator
 * uses set threshold voltage to determine arrival time
 */

package mockFinal1516Take2;

public class ThresholdTimeCalc implements ArrivalTimeCalculator {
	double threshold;
	
	/**
	 * gets arrival time for first signal above threshold voltage
	 * @param threshold - threshold voltage used
	 * @throws Exception
	 */
	public ThresholdTimeCalc (double threshold) throws Exception {
		this.threshold = threshold;
		
		// negative or zero values will not return a valid arrival time
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
