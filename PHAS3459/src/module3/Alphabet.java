package module3;

import java.util.Random;

public class Alphabet {
	
	public static char randomCharacter() {
		Random rand_int = new Random();
		int random_int = rand_int.nextInt(128);
		System.out.println(random_int);
		char character = (char) random_int;
		return character;
		}
	
	
	public static void main(String[] args) {
		//System.out.println(randomCharacter());
		int i = 0; // initialise i
		int maxloop = 250; // set max loop counter
		for (i = 0; i < maxloop; i++ ) {
			System.out.println(randomCharacter());
		}
	}

}
