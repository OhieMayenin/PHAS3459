/** This class will define a square matrix object, as well as some methods that are relevant to square matrices.
 */

package module5;

import java.lang.reflect.Array;


public class SquareMatrix {

	public int numOfRows;
	public int numOfColumns;
	double [][] elements;


	/* Constructor for the SquareMatrix object
	 * takes a 2-D array of doubles as the input
	 * finds number of rows and columns of input 
	 * throws exception for non-square matrices
	 */
	public SquareMatrix (double[][] elementsIn) throws Exception {
		elements = elementsIn; // set elements as input
		this.numOfRows =  elements.length; // gets number of rows
		this.numOfColumns = Array.getLength(elements[0]); // gets number of columns
		
		// testing if input is square matrix
		if (numOfRows != numOfColumns) {
			throw new Exception("ERROR: Not a valid square matrix --> x and y dimensions must be equal.");
		}
	}

	// writing methods for square matrix operations
	
	
	// toString method will output square matrix objects in suitable format
	public String toString () {
		int i; // rows
		int j; //columns
		StringBuilder stringBuilder = new StringBuilder(); // instantiate StringBuilder

		// counting rows
		for (i = 0; i < this.numOfRows; i++ ) {

			double[] row_i = new double [numOfColumns];
			row_i = elements[i];

			// counting elements in each row
			for (j = 0; j < this.numOfColumns; j++) {
				double doubElement = row_i[j]; // extract each element in row
				stringBuilder.append(doubElement+", "); // append element to stringBuilder
			}
			stringBuilder.append("\n");
		}
		String str = "{"+ stringBuilder.toString() +"}";
		return str;
	}

	/* unitMatrix method will output unit matrix of given size
	 * 'size' input defines dimensions of unit matrix to be returned
	 */
	public static SquareMatrix unitMatrix (int size) {
		int element;
		SquareMatrix id_matrix = null; // initialise identity matrix variable

		double [][] id = new double [size][size]; // instantiate 2-D array with input dimensions
		for (element = 0; element < size; element++) {
			id[element][element] = 1; // set diagonal elements to 1
		}

		try {
			id_matrix = new SquareMatrix(id);	// 'convert' this 2-D array to SquareMatrix object
		}

		catch (Exception e) {e.printStackTrace();}

		return id_matrix;
	}

	/*	non-static method checks if two square matrices have the same elements
	 *  input object to be compared
	 */
	public boolean equals(Object obj) {
		boolean ans = true;
		if (obj == this) {ans = true;}
		else if ((obj == null) || obj.getClass() != this.getClass()) {ans = false;}
		return ans;
	}


	/*	method adds two square matrices
	 *	inputs are the two square matrices to be added, sm1 and sm2
	 */
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if ((sm1.numOfRows != sm2.numOfRows) || (sm1.numOfColumns != sm2.numOfColumns)) { // check that inputs have same dimensions
			throw new Exception("ERROR: Cannot add square matrices of different sizes."); // throw exception if they have different dimensions
		}

		double [][] sumMatrix = new double [sm1.numOfRows][sm1.numOfColumns]; // instantiate 2-D array of same dimensions as inputs
		int i = 0;
		int j = 0;
		
		// for loops add elements together
		for (i = 0; i < sm1.numOfRows; i++ ) {
			for (j = 0; j < sm1.numOfColumns; j++) {
				sumMatrix[i][j] = sm1.elements[i][j] + sm2.elements[i][j];			
			}
		}
		SquareMatrix sumSqMatrix = new SquareMatrix (sumMatrix); // convert 2-D array to SquareMatrix object
		return sumSqMatrix;

	}


	/*	method subtracts square matrix sm2 from square matrix sm1
	 *  takes SquareMatrix arguments sm1 and sm2
	 */
	public static SquareMatrix subtract (SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if ((sm1.numOfRows != sm2.numOfRows) || (sm1.numOfColumns != sm2.numOfColumns)) { // check if input matrices have same dimensions
			throw new Exception("ERROR: Cannot add square matrices of different sizes."); // throw exception if they have different dimensions
		}

		double [][] subtractMatrix = new double [sm1.numOfRows][sm1.numOfColumns]; // instantiate new 2-D array with same dimensions as inputs
		int i = 0; // integer that counts rows
		int j = 0; // integer that counts columns
		
		// for loops calculate subtractions for each element
		for (i = 0; i < sm1.numOfRows; i++ ) {
			for (j = 0; j < sm1.numOfColumns; j++) {
				subtractMatrix[i][j] = sm1.elements[i][j] - sm2.elements[i][j];
			}	
		}
		SquareMatrix subtractSqMatrix = new SquareMatrix (subtractMatrix); // convert 2-D array to SquareMatrix
		return subtractSqMatrix;
	}


	/*	method multiplies square matrix sm2 with square matrix sm1
	 *  takes SquareMatrix arguments sm1 and sm2
	 */
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if (sm1.numOfRows != sm2.numOfColumns || sm1.numOfColumns != sm2.numOfRows) { 
			// checks if inputs can be multiplied
			throw new Exception("ERROR: The matrices inputted cannot be multiplied due to their sizes."
					+ " The number of columns of one must equal the number of rows of the other, or vice versa.");
			// throw exception if inputs cannot be multiplied
		}
		double [][] productMatrix = new double [sm1.numOfRows][sm2.numOfColumns]; // instantiate new 2-D array for product matrix
		int i = 0;
		int j = 0;
		
		// for loops calculate each element of the product matrix
		for (i = 0; i < sm1.numOfColumns; i++) {
			for (j = 0; j < sm1.numOfColumns; j++) {
				for (int k = 0; k < sm1.numOfColumns; k++)
					productMatrix[i][j] += sm1.elements[i][k] * sm2.elements[k][j]; 
			}
		}

		SquareMatrix prodSqMatrix = new SquareMatrix (productMatrix); // convert 2-D array to SquareMatrix
		return prodSqMatrix;

	}


	// writing non-static versions of all static methods written above

	public SquareMatrix add(SquareMatrix sm2) throws Exception {

		return add(this,sm2);
	}

	public SquareMatrix subtract(SquareMatrix sm2) throws Exception {

		return subtract(this,sm2);
	}

	public SquareMatrix multiply(SquareMatrix sm2) throws Exception {

		return multiply(this,sm2);
	}


}

