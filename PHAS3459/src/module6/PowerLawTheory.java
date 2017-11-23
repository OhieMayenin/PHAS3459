/** This class implements the Theory interface
 * 	defines power law function y = x^n
 */

package module6;

public class PowerLawTheory 
implements Theory {

	double n;

	// constructor initialises n in y = x^n
	public PowerLawTheory(double n) {
		this.n = n;
	}

	public double y(double x) {
		double yCurve = Math.pow(x, n);
		return yCurve;
	}

	// toString for PowerLawTheory
	public String toString() {
		String str = "y = x^"+n;
		return str;
	}
}
