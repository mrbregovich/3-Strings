package by.mrbregovich.strings;

/*
 * ������ X ������� �� ���������� �����������, ������ �� ������� ��������� ������, 
 * ��������������� ��� �������������� ������. ���������� ���������� ����������� � ������ X.
 */

class Task10 {
	public static void main(String[] args) {
		String str = "Hello world! Hello world. Hello world?";
		System.out.println(count�lauses(str));
	}

	private static int count�lauses(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '.' || ch == '?' || ch == '!')
				count++;
		}
		return count;
	}
}
