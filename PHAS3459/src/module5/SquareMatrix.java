package module5;

import java.lang.reflect.Array;

import module2.ThreeVector;

public class SquareMatrix {

	public int numOfRows;
	public int numOfColumns;

	double[][] elements;

	// constructor
	public SquareMatrix (double[][] elementsIn) throws Exception {
		elements = elementsIn;
		this.numOfRows =  elements.length;
		this.numOfColumns = Array.getLength(elements[0]);

		if (numOfRows != numOfColumns) {
			throw new Exception("ERROR: Not a valid square matrix --> x and y dimensions must be equal.");
		}
	}

	// methods
	public String toString () {
		int i; // rows
		int j; //columns
		StringBuilder stringBuilder = new StringBuilder();

		// counting rows
		for (i = 0; i < this.numOfRows; i++ ) {

			double[] row_i = new double [numOfColumns];
			row_i = elements[i];

			// counting elements in each row
			for (j = 0; j < this.numOfColumns; j++) {
				double doubElement = row_i[j];
				stringBuilder.append(doubElement+", ");
			}
			stringBuilder.append("\n");
		}
		String str = "{"+ stringBuilder.toString() +"}";
		return str;
	}


	public static SquareMatrix unitMatrix (int size) {
		int element;
		SquareMatrix id_matrix = null;

		double [][] id = new double [size][size];
		for (element = 0; element < size; element++) {
			id[element][element] = 1;
		}

		try {
			id_matrix = new SquareMatrix(id);	
		}

		catch (Exception e) {}

		return id_matrix;
	}


	public boolean equals(Object obj) {
		boolean ans = true;
		if (obj == this) {ans = true;}
		else if ((obj == null) || obj.getClass() != this.getClass()) {ans = false;}
		return ans;
	}




	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if ((sm1.numOfRows != sm2.numOfRows) || (sm1.numOfColumns != sm2.numOfColumns)) {
			throw new Exception("ERROR: Cannot add square matrices of different sizes.");
		}

		double [][] sumMatrix = new double [sm1.numOfRows][sm1.numOfColumns];
		int i = 0;
		int j = 0;

		for (i = 0; i < sm1.numOfRows; i++ ) {
			for (j = 0; j < sm1.numOfColumns; j++) {
				sumMatrix[i][j] = sm1.elements[i][j] + sm2.elements[i][j];			
			}
		}
		SquareMatrix sumSqMatrix = new SquareMatrix (sumMatrix);
		return sumSqMatrix;

	}



	public static SquareMatrix subtract (SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if ((sm1.numOfRows != sm2.numOfRows) || (sm1.numOfColumns != sm2.numOfColumns)) {
			throw new Exception("ERROR: Cannot add square matrices of different sizes.");
		}

		double [][] subtractMatrix = new double [sm1.numOfRows][sm1.numOfColumns];
		int i = 0;
		int j = 0;

		for (i = 0; i < sm1.numOfRows; i++ ) {
			for (j = 0; j < sm1.numOfColumns; j++) {
				subtractMatrix[i][j] = sm1.elements[i][j] - sm2.elements[i][j];
			}	
		}
		SquareMatrix subtractSqMatrix = new SquareMatrix (subtractMatrix);
		return subtractSqMatrix;
	}



	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if (sm1.numOfRows != sm2.numOfColumns || sm1.numOfColumns != sm2.numOfRows) {
			throw new Exception("ERROR: The matrices inputted cannot be multiplied due to their sizes."
					+ " The number of columns of one must equal the number of rows of the other, or vice versa.");
		}
		double [][] productMatrix = new double [sm1.numOfRows][sm2.numOfColumns];
		int i = 0;
		int j = 0;

		for (i = 0; i < sm1.numOfColumns; i++) {
			for (j = 0; j < sm1.numOfColumns; j++) {
				for (int k = 0; k < sm1.numOfColumns; k++)
					productMatrix[i][j] += sm1.elements[i][k] * sm2.elements[k][j]; 
			}
		}

		SquareMatrix prodSqMatrix = new SquareMatrix (productMatrix);
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

