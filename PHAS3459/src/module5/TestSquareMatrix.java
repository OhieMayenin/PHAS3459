/** 
 *  This class will test the methods written in the SquareMatrix class
 */

package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {
		
		// initialise all Square Matrices
		SquareMatrix A = null; 
		SquareMatrix B = null;
		SquareMatrix C = null;
		SquareMatrix D = null;
		
		// 2-D double arrays to be converted to SquareMatrix objects
		double [][] a = { {1 , 2 , 0},
		 		   		  {0 , 2 , 0},
		 		   	      {-2 , 0 , 1} } ;
		
		double [][] b = { {2 , 1 , 0},
		 		   	      {0 , 1 , 0},
		 		   	      {-1 , 0 , 1} } ;
		 
		double [][] c = { {4 , 3},
		 		   	      {3 , 2} } ;
		 
		double [][] d = { {-2 , 3},
		 		   	      {3 , -4} } ;
		
		 
		try { 
		
		// converting all 2-D arrays into SquareMatrix objects
		
		A = new SquareMatrix (a);
		System.out.println("Square Matrix A: \n " +A + "\n");
		
		B = new SquareMatrix (b);
		System.out.println("Square Matrix B: \n " +B+ "\n");
			
		C = new SquareMatrix (c);
		System.out.println("Square Matrix C: \n " +C+ "\n");
			
		D = new SquareMatrix (d);
		System.out.println("Square Matrix D: \n " +D+ "\n");
		
		}
		
		catch (Exception e) {e.printStackTrace();}
		
		
		try {
		SquareMatrix sumAB = SquareMatrix.add(A, B); // calculating sum of A and B
		System.out.println("The sum of A & B:" +sumAB);
		}
		catch (Exception e) {}
		
	
		try {
		SquareMatrix subtractAB = SquareMatrix.subtract(A, B); // subtracting B from A
		System.out.println("Subtracting B from A: " +subtractAB);
		}
		catch (Exception e) {}
		
	
		try {
		SquareMatrix productAB = SquareMatrix.multiply(A, B); // multiplying A by B
		System.out.println("A*B = " +productAB + "\n");
		
		SquareMatrix productBA = SquareMatrix.multiply(B, A); // multiplying B by A
		System.out.println("B*A  = " +productBA + "\n");
		
		SquareMatrix commutatorAB = SquareMatrix.subtract(productAB, productBA); // finding the commutator [A,B]
		System.out.println("Commutator [A,B] = " +commutatorAB + "\n");
		}
		
		catch (Exception e) {e.printStackTrace();}
		
		
		try {
			
			// checking whether the product of C and D equals the identity matrix
			SquareMatrix productCD = SquareMatrix.multiply(C, D);
			
			int size = C.numOfRows; // finding height of C
			SquareMatrix identity = SquareMatrix.unitMatrix(size); // create identity matrix of same height
			boolean equalsIdentity = identity.equals(productCD); // boolean checks whether identity matrix equals the product of CD
			
			// prints result to console
			System.out.println("The product of C & D is equal to the identity matrix. This statment is: " +equalsIdentity + "\n");
		}
		
		catch (Exception e) {e.printStackTrace();}
		
		
		

}
}
