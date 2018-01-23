package goldmansachs;

import java.util.ArrayList;

public class SubStringChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Complete the function below.
	 */

	static String[] uniqueSubstrings(String inputString, int substringLength) {
		ArrayList<String> uniques = new ArrayList<String>();
		String lastSubstring = "";

		StringBuilder subStr = new StringBuilder();

		for (int j = 0; j <= inputString.length()-substringLength; j++) {
			for (int i = j; i < substringLength+j; i++) {
				subStr.append(inputString.charAt(i));
			}

			if (subStr.toString().equals(lastSubstring)) {
				lastSubstring = subStr.toString();
				uniques.add(lastSubstring);
				subStr = new StringBuilder();
			}
			
			else {
				lastSubstring = subStr.toString();
				subStr = new StringBuilder();
			}
		}
		
		String[] substrings = new String[uniques.size()];
		
		for (int k = 0; k < uniques.size(); k++) {
			substrings[k] = uniques.get(k);
		}
		
		return substrings;
	}

}
