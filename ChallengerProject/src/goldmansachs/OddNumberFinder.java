package goldmansachs;

public class OddNumberFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Complete the function below.
	 */

	static int[] oddNumbers(int l, int r) {
		int[] odds =  new int[l-r+1];
		int j = 0;

		for (int i = l; i <= r; i++) {
			if (i % 2 != 0) {
				odds[j] = i;
				j++;
			}
		}


		return odds;

	}

}
