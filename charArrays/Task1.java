package by.mrbregovich.charArrays;

/*
 * Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */

class Task1 {
	public static void main(String[] args) {
		String[] arr = { "firstNum", "secondNum", "thirdNum" };
		refactor(arr);
		for (String str : arr) {
			System.out.println(str);
		}
	}

	private static void refactor(String[] strArray) {
		for (int i = 0; i < strArray.length; i++)
			strArray[i] = camelToSnake(strArray[i]);
	}

	private static String camelToSnake(String str) {
		char[] charArr = str.toCharArray();
		int numOfReplaces = getNumOfUpperCaseLettersToReplace(charArr);
		if (numOfReplaces == 0)
			return str;
		char[] newCharArr = new char[charArr.length + numOfReplaces];
		int j = 0;
		newCharArr[j] = charArr[j++];
		for (int i = 1; i < charArr.length; i++) {
			if (Character.isLowerCase(charArr[i])) {
				newCharArr[j++] = charArr[i];
			} else {
				newCharArr[j++] = '_';
				newCharArr[j++] = Character.toLowerCase(charArr[i]);
			}
		}
		return String.valueOf(newCharArr);
	}

	private static int getNumOfUpperCaseLettersToReplace(char[] arr) {
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (Character.isUpperCase(arr[i]))
				count++;
		}
		return count;
	}
}
