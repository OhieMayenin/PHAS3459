package goldmansachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 * this method does not take into account
 * special characters or character variants
 * from other languages
 * but is much more efficient
 * @author Ohie Mayenin
 *
 */
public class AnagramChecker2 {

	public static void main(String[] args) {
		System.out.println(checkAnagram("racecar","caacerr"));
		System.out.println(checkAnagram("bacecar","rrecaca"));
		System.out.println(checkAnagram("neverhavei","neveravI"));
		System.out.println(checkAnagram("manlike", "kielman"));
		System.out.println("\n");
		System.out.println(isAnagram("manlike", "kielman"));
		System.out.println(isAnagram("boloe", "hello"));
	}

	private static boolean checkAnagram (String string1, String string2) {
		if (string1.length() != string2.length()) {
			return false;
		}

		ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList('a','b','c','d','e','f',
				'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ', '-', '_'));
		HashMap<Character,Integer> values = new HashMap<Character,Integer>();

		for (int i = 0; i < alphabet.size(); i++) {
			values.put(alphabet.get(i), i+1);
		}

		int sum1 = 0;
		int sum2 = 0;
		String str1 = string1.toLowerCase();
		String str2 = string2.toLowerCase();

		for (int i = 0; i < str1.length(); i++) {
			sum1 += values.get(str1.charAt(i));
			sum2 += values.get(str2.charAt(i));
		}

		if (sum1 == sum2) {
			return true;
		}
		else {return false;}
	}
	
	
	// super efficient way
	public static boolean isAnagram(String firstWord, String secondWord) {
	     char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
	     char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
	     Arrays.sort(word1);
	     Arrays.sort(word2);
	     return Arrays.equals(word1, word2);
	}
}
