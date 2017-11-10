package module5;


public class DataPoint {
	double x;
	double y;
	double ey;
	
	// constructor
		public DataPoint (double x, double y, double ey) {
			this.x = x;
			this.y = y;
			this.ey = ey;
		}
		
		// THIS CONSTRUCTOR IS FOR ONE DATA POINT ONLY?
		// IF NOT, THEN CHANGE TO DOUBLE[]
		
		public String toString () {
			String str = "("+ this.x + "," + this.y + "," + this.ey + ")";
			return str;
		}
		
	public double getX () {
		return x;
	}
	
	
	public double getY () {
		return y;
	}
	
	
	public double getEy () {
		return ey;
	}
		
}
