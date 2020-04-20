package by.mrbregovich.charArrays;

/*
 * В строке найти количество чисел.
 */

class Task4 {
	public static void main(String[] args) {
		String str = "1 2 3 4 5 6 7 8 9 hello 10, 1254  547 while1078true";
		int count = countNumbers(str);
		System.out.println(count);
	}

	private static int countNumbers(String str) {
		int count = 0;
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (!Character.isDigit(arr[i]))
				continue;
			count++;
			do {
				i++;
			} while (i < arr.length && Character.isDigit(arr[i]));
		}
		return count;
	}

}
