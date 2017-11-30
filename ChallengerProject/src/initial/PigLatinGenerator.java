/**
 * this class defines methods to convert English string into Pig Latin
 */
package initial;

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
			

			if (pigLatinSentence == null) {
				first = input.charAt(0);
				firstWordPassed = true;
			}

			if (pigLatinWord == null && firstWordPassed == true) {
				first = input.charAt(i);
				firstChar = Character.toString(first);
			}


			if ((input.charAt(i)) == ' ' || i == length-1) {
				pigLatinWord.append(firstChar);
				pigLatinWord.append("ay ");
				pigLatinSentence.append(pigLatinWord.toString());
				pigLatinWord = new StringBuilder ();
				i++;
			}
			else {
				pigLatinWord.append(input.charAt(i));
			}



		}


		System.out.println("In Pig Latin, that's: " +pigLatinSentence.toString());
	}

}
