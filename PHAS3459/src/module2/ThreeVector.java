package module2;

import module1.VectorMethods;

public class ThreeVector {
	// arguments for three vector
	double x; double y; double z;
	
	// constructor, used for later instantiations
	public ThreeVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
		
	// writing magnitude method for calculating the magnitude of a vector
	public double magnitude() {
		
		double mag;
		mag = Math.sqrt(x*x + y*y + z*z);
		return mag;
	}
	
	// writing method that returns unit vector in the same direction as input vector
		ThreeVector unitvector() {
			
			ThreeVector unit_vec;
			double x_ct = x/magnitude();
			double y_ct = y/magnitude(); 
			double z_ct = z/magnitude();
			
			unit_vec= new ThreeVector(x_ct,y_ct,z_ct);
			
			
			return unit_vec;
		}
		
		
	// writing method that returns String reading the components of the vector
			public String toString() {
				String elements = "("+x+","+y+","+z+")";
				return elements;
			}
				
				
			//}
	


}
