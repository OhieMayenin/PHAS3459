package module6;

import java.io.BufferedReader; // import classes
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class DataAnalysis {

	public static void main(String[] args) {
		String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt";

		try {
			ArrayList<DataPoint> experimentalData =TestDataPoints.dataFromURL(urlName);
			System.out.println(experimentalData);
			
			Theory theory1 = new PowerLawTheory(2);
			Theory theory2 = new PowerLawTheory(2.05);
			Theory theory3 = new QuadraticTheory(1,10,0);
			
			ArrayList<Theory> theories = new ArrayList<Theory>();
			theories.add(theory1);
			theories.add(theory2);
			theories.add(theory3);
			
			ChiSquared chi = null;
			
			Theory bestTheory = bestTheory(experimentalData, theories,chi);
			System.out.println("The best theoretical fit to the data using the chiSq test was found to be: " +bestTheory);
		}
		catch(IOException e) {e.printStackTrace();}

	}


	private static Theory bestTheory(ArrayList<DataPoint> data,
			ArrayList<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;
		for (Theory theory : theories) {
			double gof = GoodnessOfFitCalculator.goodnessOfFit(theory, data);
			if (first) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		return bestTheory;
	}
}
