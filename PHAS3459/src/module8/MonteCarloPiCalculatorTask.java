/**
 * this class defines a MonteCarlo Pi Calculator Task
 * estimates Pi using the MonteCarlo method
 */

package module8;

import java.util.Random;
import java.util.concurrent.Callable;

public class MonteCarloPiCalculatorTask implements Callable<Double> {
	private final long n_points;
	
	/*
	 * constructor takes argument nPoints
	 */
	public MonteCarloPiCalculatorTask(long nPoints) {
		this.n_points = nPoints;
	}
	
	// MonteCarlo method
	@Override
	public Double call() throws Exception {
		Random rand = new Random();
		long n_in = 0;
		for (long iPoint = 0; iPoint < n_points; ++iPoint) {
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			double r2 = x*x + y*y;
			if (r2 < 1.0) ++n_in;
		}
		return 4.0 * n_in / n_points;
	}
}
