package module1;

public class VectorMethods {
	public VectorMethods() {}
	
	// writing the magnitude function for a 3-D vector
	public double magnitude(double x,double y,double z) {
			 
			 double mag;
			 mag = Math.sqrt(x*x + y*y + z*z); // calculates magnitude
		     return mag;
		     
		 }
	
	public double dotProduct(double x1,double y1,double z1, double x2, double y2, double z2) {
		double dotprod;
		dotprod = x1*x2 + y1*y2 + z1*z2; // calculates dot product for two 3-D vectors
		return dotprod;
		
	public double angle(double x1,double y1,double z1, double x2, double y2, double z2) {
			double ang;
			// calculates angle between two 3-D vectors
			ang = x1;
			return ang;
		
		
		 }
	public static void main(String[] args) {
		VectorMethods vm = new VectorMethods();
		
        // calling magnitude function for vector (1,2,3)
		double mag1 = vm.magnitude(1,2,3);
		System.out.println("The magnitude of vector (1,2,3) is "+mag1);
		
		// calling dot product function
		double scalarprod = vm.dotProduct(1, 2, 3, 4, 5, 6);
		System.out.println("The scalar product of the vectors (1,2,3) and (4,5,6) is "+scalarprod);
		
		

	}

}
