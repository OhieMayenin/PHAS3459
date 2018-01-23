package goldmansachs;

import java.util.Scanner;

public class NumberFinder {

	/*
	 * Complete the function below.
	 */

	static void getArray() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = null;
		System.out.println(n);
		scan.close();
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		int k = scan.nextInt();
	}

	static String findNumber(int[] arr, int k) {
		boolean found = false;
		String verdict = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == k) {
				found = true;
				verdict ="YES";
				break;
			}
		}
		if (found == false) {
			verdict = "NO";
		}
		
		return verdict;


	}
}
