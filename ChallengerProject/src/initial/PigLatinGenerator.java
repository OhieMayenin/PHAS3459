/**
 * this class defines methods to convert English string into Pig Latin
 */
package initial;

import java.util.ArrayList;

public class PigLatinGenerator {

	// method gives pig latin conversion of input string
	public static void convertToPigLatin(String input) {
		StringBuilder pigLatinSentence = new StringBuilder ();
		StringBuilder pigLatinWord = new StringBuilder ();
		int length = input.length();
		int i;

		
		boolean firstWordPassed = false;
		
		// loop generates pig latin string
		for (i = 1; i < length; i++) {
			char first;
			String firstChar = "";
			

			if (pigLatinSentence.length() == 0) {
				first = input.charAt(0);
				firstChar = Character.toString(first);
				firstWordPassed = true;
			}
			
		
			
			if (input.charAt(i-1) == ' ' && firstWordPassed == true) {
				first = input.charAt(i);
				firstChar = Character.toString(first);
				i++;
				}
			
			if ((input.charAt(i)) == ' ') {
				pigLatinWord.append(firstChar +"ay ");
				pigLatinSentence.append(pigLatinWord.toString());
				pigLatinWord = new StringBuilder ();
				}
			
			else {
				pigLatinWord.append(input.charAt(i));
			}
			
			if (input.contains(" ") == false && pigLatinWord.length() == length-1) {
				pigLatinWord.append(firstChar +"ay ");
				pigLatinSentence.append(pigLatinWord.toString());
			}



		}


		System.out.println("In Pig Latin, that's: " +pigLatinSentence.toString());
	}

}
