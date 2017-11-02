package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {
		SquareMatrix A = null;
		SquareMatrix B = null;
		SquareMatrix C = null;
		SquareMatrix D = null;
		
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
		 
		try { A = new SquareMatrix (a);
		System.out.println("Square Matrix A: \n " +A + "\n");
		
		B = new SquareMatrix (b);
		System.out.println("Square Matrix B: \n " +B+ "\n");
			
		C = new SquareMatrix (c);
		System.out.println("Square Matrix C: \n " +C+ "\n");
			
		D = new SquareMatrix (d);
		System.out.println("Square Matrix D: \n " +D+ "\n");
		}
		
		catch (Exception e) {}
		
		
		// calculating sums
		try {
		SquareMatrix sumAB = SquareMatrix.add(A, B);
		System.out.println("The sum of A & B:" +sumAB);
		}
		catch (Exception e) {}
		
	
		try {
		SquareMatrix subtractAB = SquareMatrix.subtract(A, B);
		System.out.println("Subtracting B from A: " +subtractAB);
		}
		catch (Exception e) {}
		
	
		try {
		SquareMatrix productAB = SquareMatrix.multiply(A, B);
		System.out.println("A*B = " +productAB + "\n");
		
		SquareMatrix productBA = SquareMatrix.multiply(B, A);
		System.out.println("B*A  = " +productBA + "\n");
		
		SquareMatrix commutatorAB = SquareMatrix.subtract(productAB, productBA);
		System.out.println("Commutator [A,B] = " +commutatorAB + "\n");
		}
		catch (Exception e) {}
		
		try {
			SquareMatrix productCD = SquareMatrix.multiply(C, D);
			// System.out.println("C*D  = " +productCD);
			int size = C.numOfRows;
			SquareMatrix identity = SquareMatrix.unitMatrix(size);
			boolean equalsIdentity = identity.equals(productCD);
			System.out.println("The product of C & D is equal to the identity matrix. This statment is: " +equalsIdentity + "\n");
		}
		catch (Exception e) {}
		
		
		

}
}
