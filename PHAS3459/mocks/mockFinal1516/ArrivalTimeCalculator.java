/*
 * this interface defines the abstract method
 * to calculate the arrival time
 * of a given pulse sample
 */
package mockFinal1516;

public interface ArrivalTimeCalculator {
	double arrivalTime(PulseData pulse);
}
