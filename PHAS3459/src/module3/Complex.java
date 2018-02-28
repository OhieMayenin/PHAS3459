// This class is the same as that from module 2, except some methods can throw exceptions


package module3;

public class Complex {
	// arguments for complex number

	double re; double im;

	// constructor, used for later instantiations
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;

	}

	// defining static variables
	public static Complex ONE = new Complex(1,0);
	public static Complex ZERO = new Complex(0,0);
	public static Complex I = new Complex(0,1);


	// Defining methods for Complex class //

	// writing method that returns the real part of complex number
	public static double real(Complex c1) {
		return c1.re;

	}

	// writing method that returns the imaginary part of complex number
	public static double imag(Complex c1) {
		return c1.im;

	}

	// writing method that returns the modulus of complex number
	public static double modulus(Complex c1) {
		return Math.sqrt(c1.re*c1.re + c1.im*c1.im);

	}

	// writing method that returns the modulus of complex number
	public static double angle(Complex c1) {
		return Math.atan(c1.im/c1.re);

	}

	// writing method that returns the modulus of complex number
	public static Complex conjugate(Complex c1) {
		Complex conj = new Complex(c1.re, -1*c1.im);
		return conj;

	}

	// writing method that returns the modulus of complex number
	public static Complex normalised(Complex c1) throws Exception {
		if (c1.re == 0 && c1.im ==0) {
			throw new Exception("Cannot normalise the null vector.");
			// throws exception for null vector input
		}
		Complex norm = new Complex(c1.re/modulus(c1), (-1*c1.im)/modulus(c1));
		return norm;

	}

	// writing method that returns the modulus of complex number
	public boolean equals(Complex c) {
		if (c.re == re && c.im == im) {
			return true;
		}
		else {
			return false;
		}
	}


	// writing the toString method to represent complex numbers in suitable format
	public String toString() {
		return re+"+"+im+"i";

	}	

	// writing method that will initialise real and imaginary parts of complex number		
	public static Complex setFromModulusAngle(double mag, double ang){
		double set_re;
		double set_im;
		set_re = Math.sqrt(mag*mag / (1+ Math.tan(ang)*Math.tan(ang)));
		set_im = set_re*Math.tan(ang);	
		return new Complex(set_re,set_im);

	}

	// writing add method
	public static Complex add(Complex c1,Complex c2) {
		double re_add = c1.re + c2.re;
		double im_add = c1.im + c2.im;
		Complex sum = new Complex (re_add,im_add);
		return sum;
	}


	// writing subtract method
	public static Complex subtract(Complex c1,Complex c2) {
		double re_subt = c1.re - c2.re;
		double im_subt = c1.im - c2.im;
		Complex subtraction = new Complex (re_subt,im_subt);
		return subtraction;
	}

	// writing multiply method
	public static Complex multiply(Complex c1,Complex c2) {
		double re_times = c1.re*c2.re + (-1)*c1.im*c2.im;
		double im_times = c1.re*c2.im + c2.re*c1.im;
		Complex times = new Complex (re_times,im_times);
		return times;
	}


	// writing divide method, which divides c1 by c2
	public static Complex divide(Complex c1,Complex c2) throws Exception {
		if (c2.re ==0 & c2.im==0) {
			throw new Exception("Cannot divide by the null vector.");
			// throws exception for null vector divisor
		}
		double re_div = (c1.re*c2.re - c1.im*c2.im)/Complex.modulus(c2);
		double im_div = (c1.im*c2.re - c1.re*c2.im)/Complex.modulus(c2);
		Complex divide = new Complex (re_div,im_div);
		return divide;
	}	



}
