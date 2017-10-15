package module2;

public class TestComplex {

	public static void main(String[] args) {
		Complex c1 = new Complex(1,2);
		Complex c2 = new Complex(-2,-1);
		
		// testing real method
		double re_c1 = Complex.real(c1);
		System.out.println("The real part: "+re_c1);
		
		// testing real method
		double im_c1 = Complex.imag(c1);
		System.out.println("The imaginary part: "+im_c1);
		
		// testing real method
		double mod_c1 = Complex.modulus(c1);
		System.out.println("The modulus: "+mod_c1);

		// testing real method
		double angle_c1 = Complex.angle(c1);
		System.out.println("The argument: "+angle_c1+" radians");
		System.out.println();
		
		// testing real method
		Complex conjugate_c1 = Complex.conjugate(c1);
		System.out.println("The conjugate: "+conjugate_c1);
		
		// testing real method
		Complex normalised_c1 = Complex.normalised(c1);
		System.out.println("The normalised complex number: "+normalised_c1);
		System.out.println();
		
		// testing equals method
		Complex c =  new Complex (1,2);
		System.out.println("The statement that c is equal to c1 is: "+c1.equals(c));
		System.out.println();
		
		// testing set complex number method
		Complex set_c = Complex.setFromModulusAngle(3, Math.PI/4);
		System.out.println("The set complex number: "+set_c);
		System.out.println();
		
		// testing add method
		Complex sum = Complex.add(c1,c2);
		System.out.println("The sum of the complex numbers c1 and c2: "+sum);
		
		// testing subtract method
		Complex subtraction = Complex.subtract(c1,c2);
		System.out.println("Subtraction of c2 from c1 gives: "+subtraction);
		
		// testing multiply method
		Complex multiplication = Complex.multiply(c1,c2);
		System.out.println("The product of the complex numbers c1 and c2: "+multiplication);
		
		// testing divide method
		Complex divide = Complex.divide(c1,c2);
		System.out.println("Dividing c1 by c2 gives: "+divide);
		System.out.println();
		
		// finding product of c1 and I
		Complex prod_c1_I = Complex.multiply(c1, Complex.I);
		System.out.println("Product of c1 and I: "+prod_c1_I);
		
		// finding ratio c1/ZERO
		Complex ratio_c1_ZERO = Complex.divide(c1, Complex.ZERO);
		System.out.println("Ratio of c1 and zero: "+ratio_c1_ZERO);
		
		// finding product of c1 with c1*
		Complex prod_c1_c1conj = Complex.multiply(c1, Complex.conjugate(c1));
		System.out.println("Product of c1 and c1*: "+prod_c1_c1conj);
		
		// finding product of c2 with c2*
		Complex prod_c2_c2conj = Complex.multiply(c2, c2);
		System.out.println("Product of c2 and c2*: "+prod_c2_c2conj);
		
		// Testing static variables
		System.out.println("Complex Number 1: "+Complex.ONE);
		System.out.println("Complex Number 0: "+Complex.ZERO);
		System.out.println("Complex Number i: "+Complex.I);
		
	
	}
	
	

}
