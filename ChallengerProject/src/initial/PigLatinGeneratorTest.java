/**
 * this class tests the PigLatinGenerator
 */

package initial;

public class PigLatinGeneratorTest {

	public static void main(String[] args) {
		String str1 = "Hitler";
		String str2 = "Herne Hill";
		String str3 = "Floccinaucinihilipilification";
		String str4 = "Each word in this sentence must be converted to pig latin";
		
		PigLatinGenerator.convertToPigLatin(str1);
		PigLatinGenerator.convertToPigLatin(str2);
		PigLatinGenerator.convertToPigLatin(str3);
		PigLatinGenerator.convertToPigLatin(str4);

	}

}
