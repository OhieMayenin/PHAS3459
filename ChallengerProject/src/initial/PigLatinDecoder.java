/**
 * this class defines methods to decode a given pig latin string
 * intended to be inverse of PigLatinGenerator class
 */
package initial;

import java.util.ArrayList;

public class PigLatinDecoder {
	
	public static void decodePL (String pigLatin) { 
		int length = pigLatin.length(); // length of full PL sentence
		int i; // counters
		int j;
		int k;
		char element;

		// analysing and seperating words
		int numOfWords = 0;
		int wordLength = 0;
		ArrayList<StringBuilder> listOfWords = new ArrayList<StringBuilder>();
		ArrayList<Integer> wordLengths = new ArrayList<Integer>();
		StringBuilder PLWord = new StringBuilder ();

		for (i = 0; i < length; i++) {
			// add all non-whitespace chars
			if (pigLatin.charAt(i) != ' ') {
				PLWord.append(pigLatin.charAt(i));
			}
			
			// define new word at every whitespace
			else {
				numOfWords++;
				wordLength = PLWord.length();
				listOfWords.add(PLWord);
				wordLengths.add(wordLength);
				PLWord = new StringBuilder ();
			}
			
			// account for sentences of just one word
			if (PLWord.length() == length) {
				numOfWords = 1;
				wordLength = PLWord.length();
				listOfWords.add(PLWord);
				wordLengths.add(wordLength);
			}
			
			if (i == length-1 && PLWord.length() != length) {
				numOfWords++;
				wordLength = PLWord.length();
				listOfWords.add(PLWord);
				wordLengths.add(wordLength);
			}
		}



		// decoding word			

		
		int listOfWordsSize = listOfWords.size();
		int wordLengthsSize = wordLengths.size();
		StringBuilder word; // word being decoded
		int currentWordLength; // length of word
		char firstLetter; // first letter of word
		
		// string builders to hold decoded strings
		StringBuilder decodedSentence = new StringBuilder ();
		StringBuilder decodedWord = new StringBuilder ();

		for (j = 0; j < listOfWordsSize; j++) {
			word = listOfWords.get(j);
			currentWordLength = wordLengths.get(j);
			boolean firstLetterExtracted = false;
			
			for (k = 0; k < currentWordLength; k++) {

				if (firstLetterExtracted == false) {
					firstLetter = word.charAt(currentWordLength-3);
					decodedWord.append(firstLetter);
					firstLetterExtracted = true;
				}

				// skipping 'ay' and first letter
				if (k == currentWordLength - 1 || k == currentWordLength -2 || k == currentWordLength -3) {
					k++;
				}

				else {
					element = word.charAt(k);
					decodedWord.append(element);
				}
				
//				if ((j == listOfWordsSize - 1) && (k == currentWordLength -1)) {
//					decodedSentence.append(decodedWord);
//				}
				
		
			}
			decodedSentence.append(decodedWord +" ");
			decodedWord = new StringBuilder ();
	}
		System.out.println("The decoded sentence: " +decodedSentence.toString());
}
}
