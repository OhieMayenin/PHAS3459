package module6;

public class PowerLawTheory 
	implements Theory {
	
	double n;
	
	public PowerLawTheory(double n) {
		this.n = n;
	}
	
	public double y(double x) {
		double yCurve = Math.pow(x, n);
		return yCurve;
	}
	
	public String toString() {
		String str = "y = x^"+n;
		return str;
	}
}
