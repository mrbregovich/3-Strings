package by.mrbregovich.strings;

/*
 * Строка X состоит из нескольких предложений, каждое из которых кончается точкой, 
 * восклицательным или вопросительным знаком. Определить количество предложений в строке X.
 */

class Task10 {
	public static void main(String[] args) {
		String str = "Hello world! Hello world. Hello world?";
		System.out.println(countСlauses(str));
	}

	private static int countСlauses(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '.' || ch == '?' || ch == '!')
				count++;
		}
		return count;
	}
}
