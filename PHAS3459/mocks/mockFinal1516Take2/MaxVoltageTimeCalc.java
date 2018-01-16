package mockFinal1516Take2;

public class MaxVoltageTimeCalc implements ArrivalTimeCalculator {

	@Override
	public int run(Pulse p) {
		return p.arrivalTime;
	}

}
