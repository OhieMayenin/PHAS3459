package initial;

import java.io.*;
import java.util.Scanner;

public class Solution {
	 static Scanner s = new Scanner (System.in);
     static int maxIteration = s.nextInt();
     
     // loop iterators
     static int i;
     static int j;
     static int k;
     
     static String ccNumber;
     static String reverseCcNumber;
     static int ccNumberLength;
     static int A;
     static int B;
     static int entry;
     static String doubled = "";
     
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        run();
    }
    
    public static void run () {
       
        
  
        // process cc numbers
        for (i = 0; i < maxIteration; i++) {
            ccNumber = s.next();
            reverse(ccNumber);
            
            // calculate A
            for (j = 1; j > ccNumberLength-1;) {
                A += Character.getNumericValue(reverseCcNumber.charAt(j));
                j += 2;
            }
            
            // calculate B
            for (j = 0; j > ccNumberLength-1;) {
                doubled = ""+ (2*Character.getNumericValue(reverseCcNumber.charAt(j)));
                
                if (doubled.length() > 1) {
                    entry = (Character.getNumericValue(doubled.charAt(0)) + Character.getNumericValue(doubled.charAt(1)));
                    B += entry;
                }
                else {
                B += Integer.parseInt(doubled);
                }
                j += 2;
            }
            
            // checksum test
            
            if ((A+B) % 10 == 0){
                System.out.println("Yes");
            } 
            else {
                System.out.println("No");
            }
        }
        
        s.close();
    }
    
    // reverses input String
    public static void reverse(String input) {
        StringBuilder reverse = new StringBuilder();
        ccNumberLength =  input.length();
        
        for (k = ccNumberLength -1; i >= 0; i--) {
            reverse.append(input.charAt(i));
        }
        reverseCcNumber = reverse.toString();

    }
}
