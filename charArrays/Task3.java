package by.mrbregovich.charArrays;

/*
 * В строке найти количество цифр
 */

class Task3 {
	public static void main(String[] args) {
		String str = "Hello 123458 wor45d 7";
		System.out.println(countDigits(str));
	}

	private static int countDigits(String str) {
		int count = 0;
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (Character.isDigit(arr[i]))
				count++;
		}
		return count;
	}
}
