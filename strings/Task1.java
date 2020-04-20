package by.mrbregovich.strings;

/*
 * ƒан текст (строка). Ќайдите наибольшее количество подр€д идущих пробелов в нем.
 */

class Task1 {
	public static void main(String[] args) {
		String str = "  2   3    4     5      6          ";
		int max = getMaxCountOfSpaces(str);
		System.out.println(max);
	}

	private static int getMaxCountOfSpaces(String str) {
		if (str.isEmpty())
			return 0;
		int maxCount = 0;
		int currMax = 0;
		for (int i = 0; i < str.length(); i++) {
			while (i < str.length() && str.charAt(i) == ' ') {
				currMax++;
				i++;
			}
			if (currMax > maxCount) {
				maxCount = currMax;
				currMax = 0;
			}
		}
		return maxCount;
	}

}
