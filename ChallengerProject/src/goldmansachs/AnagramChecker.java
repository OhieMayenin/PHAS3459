package goldmansachs;

import java.util.HashMap;

/**
 * this method is irrespective of character used
 * doesn't need to hardcode english alphabet
 * a lot less efficient but is more versatile so is good compromise
 * @author Ohie Mayenin
 *
 */
public class AnagramChecker {

	public static void main(String[] args) {
		System.out.println(myIsAnagram("kkemo", "okkme"));
		System.out.println(myIsAnagram("racecar", "cerraca"));
		System.out.println(myIsAnagram("racecar", "cerraca"));

	}

	private static boolean myIsAnagram (String string1, String string2) {
		boolean result = true;
		String lowerStr1 = string1.toLowerCase();
		String lowerStr2 = string2.toLowerCase();

		// first test
		if (lowerStr1.length() != lowerStr2.length()) {
			result = false;
			return result;
		}
		HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
		for (int i = 0; i < lowerStr1.length(); i++) {
			chars.put(lowerStr1.charAt(i), i); // value is irrelevant
		}

		// check if all characters extracted exist in second string
		for (int i = 0; i < chars.size(); i++) {
			if (chars.get(lowerStr2.charAt(i)) != null) {
				chars.remove(lowerStr2.charAt(i)); // to account for duplicate chars
			}
			else if (chars.get(lowerStr2.charAt(i)) == null) {
				result = false;
				return result;
			}
			// if letter remains
			else if (chars.size() != 0) {
				result = false;
				return result;
			}
		}
		System.out.println(chars);
		return result;
	}
}



