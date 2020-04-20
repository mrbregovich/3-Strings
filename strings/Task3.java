package by.mrbregovich.strings;

/*
 * ���������, �������� �� �������� ����� �����������.
 */

class Task3 {
	public static void main(String[] args) {
		String str = "abcdgdcba";
		System.out.println(isPalindrom(str));
	}

	private static String reverse(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		return sb.toString();
	}

	private static boolean isPalindrom(String str) {
		return str.equalsIgnoreCase(reverse(str));
	}
}
