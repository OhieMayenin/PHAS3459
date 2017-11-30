/**
 * this class contains methods to reverse any given string
 */

package initial;

public class StringReverser {

	// method reverses input string character by character
	public static void reverse(String input) {
		StringBuilder reversedString = new StringBuilder();
		
		int i; // counter
		int length = input.length(); // get number of characters in string

		// loop reverses string
		for (i = length-1; i >= 0; i--) {
			reversedString.append(input.charAt(i));
		}
		
		String str = reversedString.toString();
		
		System.out.println("In reverse, that's: " +str +"\n");
	}
	
}
