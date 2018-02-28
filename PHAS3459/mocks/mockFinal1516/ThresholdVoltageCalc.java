package mockFinal1516;

public class ThresholdVoltageCalc implements ArrivalTimeCalculator {
	private double threshold;
	
	public ThresholdVoltageCalc(double threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public double arrivalTime(PulseData pulse) {
		// TODO Auto-generated method stub
		int time = 0;
		
		for (String signal : pulse.data) {
			time++;
			if (Double.parseDouble(signal) > threshold) {
			break;	
			}
		}
		return time;
	}
}
