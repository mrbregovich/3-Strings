package by.mrbregovich.strings;

/*
 * ѕосчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. 
 * ”читывать только английские буквы.
 */

class Task9 {
	public static void main(String[] args) {
		String str = "Hello JAVA wooorld";
		System.out.println("UpperCase Letters: " + countUpperCaseLetters(str));
		System.out.println("LowerCase Letters: " + countLowerCaseLetters(str));
	}

	private static int countLowerCaseLetters(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			int ch = str.charAt(i);
			if (Character.isLetter(ch) && Character.isLowerCase(ch))
				count++;
		}
		return count;
	}

	private static int countUpperCaseLetters(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			int ch = str.charAt(i);
			if (Character.isLetter(ch) && Character.isUpperCase(ch))
				count++;
		}
		return count;
	}
}
