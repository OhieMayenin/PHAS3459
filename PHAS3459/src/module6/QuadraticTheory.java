/** This class implements the Theory interface
 * 	defines quadratic function y = ax^2 + bx + c
 */

package module6;

public class QuadraticTheory implements Theory {

	double a;
	double b;
	double c;

	/* constructor for QuadraticTheory
	 * initialises constants a, b, c
	 */
	QuadraticTheory(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double y(double x) {
		double yCurve = a*x*x + b*x + c;
		return yCurve;
	}

	// toString for QuadraticTheory
	public String toString() {
		String str = null;

		// if constant is equal to zero, remove corresponding order from string
		if (a != 0 && b != 0 && c != 0) {
			str = "y = "+a +"x^2 + " +b +"x + " +c;
		}

		if (a == 0 ) {
			str = "y = " +b +"x + " +c;
		}

		if (b == 0 ) {
			str = "y = "+a +"x^2 + " +c;
		}

		if (c == 0 ) {
			str = "y = "+a +"x^2 + " +b +"x";
		}

		return str;

	}
}
