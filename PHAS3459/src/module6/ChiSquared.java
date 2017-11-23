/** This class implements the GoodnessOfFitCalculator interface
 * 	defines the chi squared test
 */

package module6;

import java.util.ArrayList;


public class ChiSquared implements GoodnessOfFitCalculator {

	public ChiSquared() {} // constructor

	public double goodnessOfFit(Theory theoretical, ArrayList<DataPoint> dataPoints){

		int i; // initialise loop counter
		double sum_chiSq = 0; // initialise chiSq value

		// for loop will sum together the X squared value from all dataPoints
		for (i = 0; i < dataPoints.size(); i++ ){
			DataPoint element = dataPoints.get(i); // extract each DataPoint from ArrayList input
			double chiSqPoint = Math.pow((element.getY() - theoretical.y(element.getX())),2)/ (element.getEy()*element.getEy());

			sum_chiSq = sum_chiSq + chiSqPoint; // add value to running sum
		}

		return sum_chiSq;

	}
}
