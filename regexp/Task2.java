package by.mrbregovich.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ���� ������, ���������� ����� (xml-��������)
 * �������� ����������, ����������� ��������������� ���������� ���������� ����� xml-��������� � ��� ��� 
 * (����������� ���, ����������� ���, ���������� ����, ��� ��� ����). ������������ �������� ��������� 
 * XML ��� ������� ������ ������ ������.
 */

class Task2 {
	public static void main(String[] args) {
		String text = "<notes>\n" + "<note id = \"1\">\n" + "<to>����</to>\n" + "<from>�����</from>\n"
				+ "<heading>�����������</heading>\n" + "<body>������� ��� ������!</body>\n" + "</note>\n"
				+ "<note id = \"2\">\n" + "<to>����</to>\n" + "<from>����</from>\n"
				+ "<heading>������ �����������</heading>\n" + "<body/>\n" + "</note>\n" + "</notes>";
		Pattern openningTag = Pattern.compile("<[\\w\\s=\"]+?>");
		Pattern closingTag = Pattern.compile("</[\\w]+?>");
		Pattern contentTag = Pattern.compile("(<[\\w\\s=\"]+?>)(.+?)(</[\\w]+?>)");
		Pattern noBodyTag = Pattern.compile("<[\\w\\s=\"]+?/>");
		String[] lines = text.split("\n");
		Matcher matcher = null;
		for (String line : lines) {
			matcher = openningTag.matcher(line);
			if (matcher.matches()) {
				System.out.println("����������� ���: " + line);
			}
			matcher = closingTag.matcher(line);
			if (matcher.matches())
				System.out.println("����������� ���: " + line);
			matcher = noBodyTag.matcher(line);
			if (matcher.matches())
				System.out.println("��� ��� ����: " + line);
			matcher = contentTag.matcher(line);
			if (matcher.matches()) {
				System.out.println("����������� ���: " + matcher.group(1));
				System.out.println("���������� ����: " + matcher.group(2));
				System.out.println("����������� ���: " + matcher.group(3));
			}
		}
	}

}
