package module5;

public class Theory {
	double n;
	
	// constructor
	public Theory (double n) {
		this.n = n;
	}
	
	public double y (double x) {
		double yCurve = Math.pow(x, n);
		return yCurve;
	}
}
