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
		char first;
		String firstChar = "";

		// loop generates pig latin string
		for (i = 1; i < length; i++) {



			if (firstWordPassed == false) {
				first = input.charAt(0);
				firstChar = Character.toString(first);
				firstWordPassed = true;
			}


			// creates new word at whitespace
			if ((input.charAt(i)) == ' ') {
				pigLatinWord.append(firstChar +"ay ");
				pigLatinSentence.append(pigLatinWord.toString());
				pigLatinWord = new StringBuilder ();
				i++;
				first = input.charAt(i);
				firstChar = Character.toString(first);				
			} 

			else {
				pigLatinWord.append(input.charAt(i));
			}

			// final word check
			if (i == length -1 ) {
				pigLatinWord.append(firstChar +"ay ");
				pigLatinSentence.append(pigLatinWord.toString());
			}

			if (pigLatinWord.length() == length-1) {
				pigLatinWord.append(firstChar +"ay ");
				pigLatinSentence.append(pigLatinWord.toString());
			}




		}


		System.out.println("In Pig Latin, that's: " +pigLatinSentence.toString());
	}

}
