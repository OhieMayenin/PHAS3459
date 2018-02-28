/**	This class will contain a constructor for a 'Theory' object
 * 	and a method that takes input and returns that input to the power n
 *  which is defined by Theory object
 */

package module5;

public class Theory {
	double n;
	
	// constructor for Theory object which takes argument n
	public Theory (double n) {
		this.n = n;
	}
	
	// non-static method that takes argument x and returns x^n
	public double y (double x) {
		double yCurve = Math.pow(x, n);
		return yCurve;
	}
}
