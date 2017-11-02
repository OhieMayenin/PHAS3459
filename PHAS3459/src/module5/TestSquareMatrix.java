package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {
		SquareMatrix A;
		SquareMatrix B;
		SquareMatrix C;
		SquareMatrix D;
		
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
		System.out.println(sumAB);
		}
		catch (Exception e) {}
		}

}
