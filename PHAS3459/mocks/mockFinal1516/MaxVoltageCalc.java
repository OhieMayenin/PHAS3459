package mockFinal1516;

public class MaxVoltageCalc implements ArrivalTimeCalculator {
	
	@Override
	public double arrivalTime(PulseData pulse) {
		// TODO Auto-generated method stub
		double amplitude = 0;
		
		for (String signal : pulse.data) {
			if (Double.parseDouble(signal) > amplitude) {
				amplitude = Double.parseDouble(signal);
			}
		}
		
		int time = 0;
		for (String signal : pulse.data) {
			time++;
			if (Double.parseDouble(signal) == amplitude) {
				break;
			}
		}
		return time;
	}
}