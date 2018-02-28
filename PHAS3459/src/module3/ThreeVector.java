// This class is the same as that from module 2, but some methods here throw exceptions

package module3;

public class ThreeVector {
	// arguments for three vector
	double x; double y; double z;

	// constructor, used for later instantiations
	public ThreeVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;

	}


	// DEFINING STATIC VERSIONS OF ALL METHODS //

	// writing magnitude method for calculating the magnitude of a vector
	public static double magnitude(ThreeVector v1) {
		double mag;
		mag = Math.sqrt(v1.x*v1.x + v1.y*v1.y + v1.z*v1.z);
		return mag;
	}

	// writing method that returns unit vector in the same direction as input vector
	public static ThreeVector unitvector(ThreeVector v1) throws Exception {
		if (v1.x ==0 && v1.y ==0 && v1.z ==0) {
			throw new Exception("The null vector has no unit vector associated with it.");
			// throws exception for null vector input
		}	
		ThreeVector unit_vec;
		double x_ct = v1.x/magnitude(v1);
		double y_ct = v1.y/magnitude(v1); 
		double z_ct = v1.z/magnitude(v1);

		unit_vec= new ThreeVector(x_ct,y_ct,z_ct);


		return unit_vec;
	}


	// writing scalar product method for calculating scalar product of two vectors
	public static double scalarProduct(ThreeVector v1,ThreeVector v2) {

		double scal_prod;
		scal_prod = v1.x*v2.x + v1.y*v2.y + v1.z*v2.z;
		return scal_prod;
	}

	// writing scalar product method for calculating scalar product of two vectors
	public static ThreeVector vectorProduct(ThreeVector v1,ThreeVector v2) {

		ThreeVector vect_prod;
		double i = v1.y*v2.z - v1.z*v2.y;
		double j = v1.x*v2.z - v1.z*v2.x;
		double k = v1.x*v2.y - v1.y*v2.x;

		vect_prod = new ThreeVector(i,j,k);

		return vect_prod;
	}

	// writing add method for adding two three vectors
	public static ThreeVector add(ThreeVector v1, ThreeVector v2) {

		ThreeVector sum;
		double e_i = v1.x + v2.x;
		double e_j = v1.y + v2.y;
		double e_k = v1.z + v2.z;

		sum = new ThreeVector(e_i,e_j,e_k);

		return sum;

	}

	// writing angle method for calculating the angle between two vectors
	public static double angle(ThreeVector v1, ThreeVector v2) throws Exception {
		if (v1.x*v2.x ==0 && v1.y*v2.y ==0 && v1.z*v2.z ==0) {
			throw new Exception("There is no angle between a non-zero vector and a null vector.");
			// throws exception for any null vector inputs
		}	
		double numerator = scalarProduct(v1,v2);
		double denominator = magnitude(v1)*magnitude(v2);

		double ang = Math.acos(numerator/denominator);

		return ang;

	}		

	// writing in string method in order to represent ThreeVectors in a suitable format when printing to console
	public String toString() {
		return "("+x+","+y+","+z+")";

	}



	// NOW DEFINING NON STATIC VERSIONS OF ALL METHODS //


	// writing scalar product method for calculating scalar product of two vectors
	public double scalarProduct(ThreeVector v2) {

		return scalarProduct(this,v2);
	}

	// writing scalar product method for calculating scalar product of two vectors
	public ThreeVector vectorProduct(ThreeVector v2) {

		return vectorProduct(this,v2);
	}

	// writing add method for adding two three vectors
	public ThreeVector add(ThreeVector v2) {

		return add(this,v2);

	}

	// writing angle method for calculating the angle between two vectors
	//		public double angle(ThreeVector v2) {
	//		
	//		return angle(this,v2);

	//	}






}
