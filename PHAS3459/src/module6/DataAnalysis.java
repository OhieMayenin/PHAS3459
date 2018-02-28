/** this main class reads URL data and compares it to theory objects
 * 	determines the best fit for the data using chiSq test
 */

package module6;


import java.io.IOException; // import classes
import java.util.ArrayList;



public class DataAnalysis {

	public static void main(String[] args) {
		String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt"; // URL to be read

		try {
			ArrayList<DataPoint> experimentalData =TestDataPoints.dataFromURL(urlName); // read URL and return ArrayList of DataPoints
			System.out.println(experimentalData);

			// instantiate Theory objects to be tested
			Theory theory1 = new PowerLawTheory(2);
			Theory theory2 = new PowerLawTheory(2.05);
			Theory theory3 = new QuadraticTheory(1,10,0);

			// add these Theory objects to ArrayList
			ArrayList<Theory> theories = new ArrayList<Theory>();
			theories.add(theory1);
			theories.add(theory2);
			theories.add(theory3);

			ChiSquared calculator = new ChiSquared(); //  in order to call non-static method

			// determine Theory that best fits the data
			Theory bestTheory = bestTheory(experimentalData, theories,calculator);
			System.out.println("\n" +"The best theoretical fit to the data using the chiSq test is: " +bestTheory);
		}
		catch(IOException e) {e.printStackTrace();}

	}

	/*
	 * bestTheory method determines the Theory object that best fits a set of data
	 * takes arguments:
	 *  - data : data to be fitted
	 *  - theories : ArrayList of all theory objects to be tested
	 *  - gofCalculator : object which references method to be used, in this case the chi squared test
	 */
	private static Theory bestTheory(ArrayList<DataPoint> data,
			ArrayList<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;

		// for loop tests each theory object
		for (Theory theory : theories) {
			double gof = gofCalculator.goodnessOfFit(theory, data);
			System.out.println("\n"+"The chi squared value for " +theory + " is: " +gof);
			if (first) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory; // sets theory object to bestTheory if chiSq value is smallest
				bestGoodnessOfFit = gof; // sets this value of chiSq as new best/lowest
			}
		}
		return bestTheory;
	}
}
