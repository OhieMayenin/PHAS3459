package module6;

public class QuadraticTheory 
	implements Theory {
	
	double a;
	double b;
	double c;
	
	QuadraticTheory(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double y(double x) {
		double yCurve = a*x*x + b*x + c;
		return yCurve;
	}
	
	public String toString() {
		String str = "y = "+a +"x^2 + " +b +"x + " +c;
		return null;
	}
}
