package by.mrbregovich.strings;

/*
 * ����������, ������� ��� ����� �������� �������� ������ ����������� ����� ���.
 */

class Task5 {
	public static void main(String[] args) {
		String str = "abasd fagha";
		System.out.println(countChar(str, 'A'));
	}

	private static int countChar(String source, char letter) {
		return (int) source.chars().filter(ch -> Character.toLowerCase(ch) == Character.toLowerCase(letter)).count();
	}

}
