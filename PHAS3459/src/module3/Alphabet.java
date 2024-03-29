// This class will generate random characters, and manipulate them in different ways

package module3;

// importing classes
import java.util.Random;
import java.lang.Character;
import java.lang.Integer;
import java.lang.StringBuilder;

public class Alphabet {

	// method generates random character
	public static char randomCharacter() {
		Random rand_int = new Random(); // generate random integer
		int random_int = rand_int.nextInt(127); // set range to 0-128
		// System.out.println(random_int);
		char character = (char) random_int; // convert int to char
		return character; 
	}


	public static void main(String[] args) {
		//System.out.println(randomCharacter());
		int i = 0; // initialise i
		int number_of_elements = 0; // initialise counter to count length of string builder
		int maxloop = 250; // set max loop counter
		int total = 0; // initialise total of the sum of digits
		int exception_counter = 0; // initialise number of exceptions thrown
		StringBuilder characters = new StringBuilder(); // create StringBuilder object
		
		// loop outputs 250 characters to console
		for (i = 0; i < maxloop; i++ ) {
			char char_out = randomCharacter();
			// boolean checks if output is either letter or digit
			boolean condition = Character.isDigit(char_out) || Character.isLetter(char_out);
			// if output is letter or digit, will add to string builder
			try { if (condition == true) {
				characters.append(char_out);
				number_of_elements = number_of_elements + 1; // counting elements in string builder
				String str = ""+char_out; // convert char to string
				total = total + Integer.parseInt(str); // summing integer representations of characters in string builder
			}
			}
			catch (Exception e) {exception_counter = exception_counter +1;} 
			// catching exceptions, counting how many exceptions are caught
		}
		
		// all print statements
		System.out.println("All the letter and number outputs: "+characters);
		System.out.println("");
		System.out.println("Number of elements in the String Builder: "+number_of_elements);
		System.out.println("The sum of the integer representations of the characters: "+total);
		System.out.println("The number of exceptions caught: "+exception_counter);
	}

}
