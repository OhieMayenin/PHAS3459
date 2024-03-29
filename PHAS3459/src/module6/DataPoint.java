/**	This class will define a 'DataPoint' constructor
 * 	and will write various methods relating to DataPoint variables
 * 	it will act as a superclass for the LabelledDataPoint subclass
 */

package module6;


public class DataPoint {
	double x;  // x-value
	double y;  // y-value
	double ey; // error on y-value

	/*	constructor for DataPoint object
	 *  takes arguments x, y and ey
	 */
	public DataPoint (double x, double y, double ey) {
		this.x = x;
		this.y = y;
		this.ey = ey;
	}

	// writing toString method to print DataPoint in suitable format
	public String toString () {
		String str = "( x = "+ this.x + ", y = " + this.y + "+-" + this.ey + " )" +"\n";
		return str;
	}


	// gets x-value from DataPoint
	public double getX () {
		return this.x;
	}

	// gets y-value from DataPoint
	public double getY () {
		return this.y;
	}

	// gets error on y-value from DataPoint
	public double getEy () {
		return this.ey;
	}

}
