// Binary addition of two number
// https://leetcode.com/problems/add-binary/description/#
public class BinaryAddition {

	public static String binaryAddtion(String a, String b) {

		StringBuilder resultSum = new StringBuilder();
		String result = "";

		// make sure each string is of same length or prepend with 0's
		if (a.length() > b.length()) {
			b = equalize(a.length(), b);
		} else if (a.length() < b.length()) {
			a = equalize(b.length(), a);
		}

		char[] aArray = a.toCharArray();
		char[] bArray = b.toCharArray();
		int carry = 0;

		
		// add each of the character 
		for (int i = a.length() - 1; i >= 0; i--) {

			int add = Character.getNumericValue(aArray[i]) + Character.getNumericValue(bArray[i]) + carry;
			// Based on add, assign carry and the result
			if (add == 3) {
				resultSum.insert(0, 1);
				carry = 1;
			} else if (add == 2) {
				resultSum.insert(0, 0);
				carry = 1;
			} else if (add == 1) {
				carry = 0;
				resultSum.insert(0, 1);
			} else {
				carry = 0;
				resultSum.insert(0, 0);
			}
		}
		if (resultSum.toString().equals("0") && carry == 0)
			return resultSum.toString();

		if (carry == 0)
			return resultSum.toString();
		return resultSum.insert(0, carry).toString();
	}

	private static String equalize(int a, String b) {
		String temp = "0";
		for (int i = 0; i < (a - b.length() - 1); i++) {
			temp = temp + "0";
		}
		return temp + b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "0";
		String b = "0";
		binaryAddtion(a, b);
	}

}
