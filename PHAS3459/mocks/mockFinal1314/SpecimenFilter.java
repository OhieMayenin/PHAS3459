/*
 * this interface defines the abstract method
 * which filters through input specimens and
 * returns subset that is found within specific region
 */
package mockFinal1314;

import java.util.ArrayList;

public interface SpecimenFilter {
	ArrayList<Plant> filter(ArrayList<Plant> allSpecimens);
}
