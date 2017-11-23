/**	This class will define a 'LabelledDataPoint' object
 * 	will be a DataPoint with a string label
 * 	it is a subclass that extends the DataPoint superclass
 */

package module6;

// subclass of the superclass DataPoint
public class LabelledDataPoint extends DataPoint{
	String label; // label of dataPoint

	/*
	 * constructor for LabelledDataPoint
	 * extends superclass object by adding label String as argument
	 */
	public LabelledDataPoint(double x, double y, double ey, String label) {
		super(x, y, ey);
		this.label = label;
	}


	// toString method incorporates the label
	public String toString () {
		String str = label +": ( x = "+ this.x + ", y = " + this.y + "+-" + this.ey + " )";
		return str;
	}

}
