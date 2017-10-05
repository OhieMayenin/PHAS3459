package module1;

public class DataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Exploring different variable types
		
		double d = 10.0;
		System.out.println("d is "+d);
		float floatVar = 10;
		int intVar = 10;
		long longVar = 10;
		byte byteVar = 10;
		System.out.println(floatVar*intVar*longVar*byteVar);
		System.out.println();
		
		// Exploring how different types mix with each other
		
		char charVar = 'd'+10; // adding integer 10 to character d
		System.out.println("d+10 returns "+charVar);
		System.out.println("The code has returned another character, n, which is 10 places higher in the alphabet than our starting character c");
		
		//long example = floatVar*intVar;
		//System.out.println(example);
		System.out.println("The code in lines 19 & 20 does not run, because the product of a float and an integer cannot be converted into a long");
		
		char charVar2 = 'm'*2; // multiplying m by integer 4
		System.out.println("m*2 returns "+charVar2);
		System.out.println("Multiplying the character by an integer also outputs another character.");
		
		//char chartimesfloat = 'a'*floatVar; //multiplying character f by float 2.0
		
		System.out.println("The character does not sum with or multiply with floats, as seen in code line 34");
		System.out.println();
		
		// Investigating what happens when a variable has not had its value initialised
		
		int j=1; int i;
		//j=i+1;
		//System.out.println(i);
		System.out.println("The code in lines 39 & 40 doesn't work and fails to calculate that i must be equal to zero without its value being initialised first");
		System.out.println();
		
		
		// Using a narrowing conversion, which reduces the range of possible values, e.g. from double to float or int.
		
		// Converting from double to int
		double doubleVar2 = 4.99;
		int intVar2 = (int) doubleVar2 * (int) doubleVar2;
		System.out.println("The output of this narrowing cast is "+intVar2);
		System.out.println("The conversion rounds down the doubles from 4.99 to 4, even if rounding up would be more suitable in this case");
		System.out.println();
		
		// Converting from double to int again but first multiplying doubles
		int intVar3 = (int) (doubleVar2 * doubleVar2);
		System.out.println("The output of this narrowing cast is "+intVar3);
		System.out.println("It multiplies 4.99 by itself first, and then rounds the answer down to 24, which is more accurate that the first method.");

	}

}
