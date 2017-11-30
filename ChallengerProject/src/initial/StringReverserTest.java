/**
 * this main class tests the StringReverser
 */

package initial;

public class StringReverserTest {
	
	public static void main(String[] args) {
		String string1 = "racecar";
		String string2 = "You are an incorrigible delinquent at times...";
		String string3 = "2+2=4, minus 1 that's 3 - Quick Maths.";
		
			// static reverser
		StringReverser.reverse(string1);
		StringReverser.reverse(string2);
		StringReverser.reverse(string3);
			
	}

}
