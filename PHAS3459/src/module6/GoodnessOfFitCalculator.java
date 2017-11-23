/** This interface defines classes for finding best theoretical fits for data
 * 	classes that implement this interface use a theoretical fit equation and data to compare
 */

package module6;

import java.util.ArrayList;

public interface GoodnessOfFitCalculator {
	double goodnessOfFit(Theory theoretical, ArrayList<DataPoint> dataPoints);
}
