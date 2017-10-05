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
		
		 }
		
	public double angle(double x1,double y1,double z1, double x2, double y2, double z2) {
			double ang;
			// calculates angle between two 3-D vectors
			ang = Math.acos((dotProduct(x1,y1,z1,x2,y2,z2))/(magnitude(x1,y1,z1)*magnitude(x2,y2,z2)));
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
		
		// calling angle function to calculate angle between two vectors
		// angle 1 between vectors (2,3,4) and (1,3,2)
		double angle1 = vm.angle(2, 3, 4, 1, 3, 2);
		System.out.println("The angle between vectors (2,3,4) and (1,3,2) is "+angle1 +" radians");
		
		// angle 2 between vectors (2,3,4) and (0,0,0)
		double angle2 = vm.angle(2, 3, 4, 0, 0, 0);
		System.out.println("The angle between vectors (2,3,4) and (0,0,0) is "+angle2 +" radians");
	}

}
