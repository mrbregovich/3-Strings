package by.mrbregovich.strings;

/*
 * � ������� ������� ����������� � �������� ������������ ��������� �� ������ ����� 
 * ������������� ����� �����.
 */

class Task4 {
	public static void main(String[] args) {
		String source = "�����������";
		String result = "";
		int tInd = source.indexOf("�");
		int orInd = source.indexOf("��");
		result = source.substring(tInd, tInd + 1) + source.substring(orInd, orInd + 2)
				+ source.substring(tInd, tInd + 1);
		System.out.println(result);
	}
}
