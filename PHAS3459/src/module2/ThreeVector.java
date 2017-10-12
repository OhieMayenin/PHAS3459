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
				
	// writing scalar product method for calculating scalar product of two vectors
			public double scalarProduct(ThreeVector v2) {
					
				double scal_prod;
				scal_prod = x*v2.x + y*v2.y + z*v2.z;
				return scal_prod;
			}
			
	// writing scalar product method for calculating scalar product of two vectors
			public ThreeVector vectorProduct(ThreeVector v2) {
					
				ThreeVector vect_prod;
				double i = y*v2.z - z*v2.y;
				double j = x*v2.z - z*v2.x;
				double k = x*v2.y - y*v2.x;
				
				vect_prod = new ThreeVector(i,j,k);
				
				return vect_prod;
						}
			
	// writing add method for adding two three vectors
			public ThreeVector add(ThreeVector v2) {
				
				ThreeVector sum;
				double e_i = x + v2.x;
				double e_j = y + v2.y;
				double e_k = z + v2.z;
				
				sum = new ThreeVector(e_i,e_j,e_k);
				
				return sum;
				
			}
			
	// writing angle method for calculating the angle between two vectors
			public double angle(ThreeVector v2) {
				
				double numerator = scalarProduct(v2);
				double denominator = magnitude()*v2.magnitude();
				
				double ang = Math.acos(numerator/denominator);
				
				return ang;
				
			}
			
			
	// NOW DEFINING STATIC VERSIONS OF ALL METHODS
			// writing magnitude method for calculating the magnitude of a vector
			public static double magnitude() {
				
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
				
						
			// writing scalar product method for calculating scalar product of two vectors
				public static double scalarProduct(ThreeVector v2) {
							
						double scal_prod;
						scal_prod = x*v2.x + y*v2.y + z*v2.z;
						return scal_prod;
					}
					
			// writing scalar product method for calculating scalar product of two vectors
				public static ThreeVector vectorProduct(ThreeVector v2) {
							
						ThreeVector vect_prod;
						double i = y*v2.z - z*v2.y;
						double j = x*v2.z - z*v2.x;
						double k = x*v2.y - y*v2.x;
						
						vect_prod = new ThreeVector(i,j,k);
						
						return vect_prod;
								}
					
			// writing add method for adding two three vectors
				public static ThreeVector add(ThreeVector v2) {
						
						ThreeVector sum;
						double e_i = x + v2.x;
						double e_j = y + v2.y;
						double e_k = z + v2.z;
						
						sum = new ThreeVector(e_i,e_j,e_k);
						
						return sum;
						
					}
					
			// writing angle method for calculating the angle between two vectors
				public static double angle(ThreeVector v2) {
						
						double numerator = scalarProduct(v2);
						double denominator = magnitude()*v2.magnitude();
						
						double ang = Math.acos(numerator/denominator);
						
						return ang;
						
					}		
			
				
	


}
