package by.mrbregovich.charArrays;

/*
 * Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов 
 * заменить на одиночные пробелы. Крайние пробелы в строке удалить.
 */

class Task5 {
	public static void main(String[] args) {
		String str = "  Hello    world    ";
		String res = deleteMultiSpaces(str);
		System.out.println(res);
	}

	private static String trimString(String str) {
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ')
				continue;
			else if (i > 0) {
				char[] temp = new char[arr.length - i];
				System.arraycopy(arr, i, temp, 0, arr.length - i);
				arr = temp;
				break;
			}
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == ' ')
				continue;
			else if (i < arr.length - 1) {
				char[] temp = new char[i + 1];
				System.arraycopy(arr, 0, temp, 0, i + 1);
				arr = temp;
				break;
			}
		}
		return String.valueOf(arr);
	}

	private static String deleteMultiSpaces(String str) {
		str = trimString(str);
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ') {
				int nextSpace = i;
				while (nextSpace + 1 < arr.length && arr[nextSpace + 1] == ' ')
					nextSpace++;
				if (i != nextSpace) {
					char[] temp = new char[arr.length - (nextSpace - i)];
					System.arraycopy(arr, 0, temp, 0, i + 1);
					System.arraycopy(arr, nextSpace + 1, temp, i + 1, arr.length - (nextSpace + 1));
					arr = temp;
				}
			}
		}
		return String.valueOf(arr);
	}
}
