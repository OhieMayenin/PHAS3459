/*
 * interface outlines a generic calculation
 * based on data from multiple Tide objects
 */

package mockFinal1415;

import java.util.ArrayList;

public interface SeaLevelCalculator {
	double run(ArrayList<Tide> tides);
}
