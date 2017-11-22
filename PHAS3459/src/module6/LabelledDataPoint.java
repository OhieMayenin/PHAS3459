package module6;

// subclass of the superclass DataPoint
public class LabelledDataPoint extends DataPoint{
	String label;
	
	public LabelledDataPoint(double x, double y, double ey, String label) {
		super(x, y, ey);
		this.label = label;
	}
	

	// writing toString method for LabelledDataPoint, which incorporates the label
			public String toString () {
				String str = label +": ( x = "+ this.x + ", y = " + this.y + "+-" + this.ey + " )";
				return str;
			}
	
}
