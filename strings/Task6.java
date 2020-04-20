package by.mrbregovich.strings;

/*
 * Из заданной строки получить новую, повторив каждый символ дважды.
 */

class Task6 {
	public static void main(String[] args) {
		String str = "abcdefg";
		System.out.println(doubleLetters(str));
	}

	private static String doubleLetters(String src) {
		StringBuilder sb = new StringBuilder(src.length() * 2);
		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i);
			sb.append(ch).append(ch);
		}
		return sb.toString();
	}
}
