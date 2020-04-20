package by.mrbregovich.regexp;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.*;

/*
 * C������ ����������, ����������� ����� (����� �������� � ������) � ����������� ��������� � ������� 
 * ��� ��������� ��������: 
 * - ������������� ������ �� ���������� �����������; 
 * - � ������ ����������� ������������� ����� �� �����;
 * - ������������� ������� � ����������� �� �������� ���������� ��������� ��������� �������, 
 * � � ������ ��������� � �� ��������.
 */

class Task1 {
	public static void main(String[] args) {
		String text = "����� ���������� ��������� ������������ � Spring ������ ��������� Bean Factory, "
				+ "������� �������� �� ���������� ������������ Spring Beans, � ��� ����� �� ������������� "
				+ "� ���������� �������. ������ ��������� Spring Bean ������������� � Spring ��� "
				+ "����������� ������ ����������, ������������ �����������. ��� �������, ���������� "
				+ "Spring Beans �������������� �� ������������ ������ ������������ ����������� "
				+ "JavaBeans, ���� ��� ������ �� �����������, �������� ���� ��� ���������� "
				+ "����������� Spring Beans ���� � ������ �������������� ��������� ��������� "
				+ "������������ ����� �����������. ��� ���� ����������� ��� ��������! Hello world.\n���� � ���������� ��������� ���� ��������� ��������� "
				+ "������������, �� � ����������� ��������� ������������ � Spring ����� ����������������� "
				+ "����� ��������� BeanFactory. � ���� ������ � ���������� ���������� ������� "
				+ "��������� ������, ������������ ��������� BeanFactory, � ���������������� ��� �� "
				+ "��������� �������� � ����������� Spri�g Beans � ������������. ��� ������ ��� ����� "
				+ "�������, ���������� Spri�g Beans ����� ���� �������� � ���������� ����� ��������� "
				+ "BeanFactory ��� ����������� ���������.\n� ���� ������� ��� ��������� ���� ��������� "
				+ "������������ �������������. �� �������� ��������������� ��������� "
				+ "���������� �������. �� ���� ��������, ����������� ����� � ���� �����, ��������� "
				+ "������ ��������� ���������� ���������� BeanFactory.";
		String choice = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (!choice.equals("0")) {
			showMenu();
			System.out.print("������� ��������: ");
			try {
				choice = br.readLine();
			} catch (IOException e) {
				System.out.println("������������ ����");
			}
			switch (choice) {
			case "1":
				System.out.println("\n" + text + "\n");
				break;
			case "2":
				System.out.println("\n" + sortParagraphes(text) + "\n");
				break;
			case "3":
				System.out.println("\n" + sortPhrases(text) + "\n");
				break;
			case "4":
				System.out.println("\n" + sortWords(text) + "\n");
				break;
			case "0":
				break;
			default:
				System.out.println("������������ ����");
			}
		}
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String sortWords(String text) {
		String[] phrases = text.split("[.!?]+\\s*");
		StringBuilder sb = new StringBuilder();
		for (String phrase : phrases) {
			String[] words = phrase.split("\\PL+");
			Arrays.sort(words, Comparator.comparingInt((String word) -> countCharacters('�', word)).reversed()
					.thenComparing(Comparator.naturalOrder()));
			sb.append(String.join(" ", words)).append("\n");
		}
		return sb.toString();
	}

	private static String sortPhrases(String text) {
		String[] phrases = text.split("[.!?]+\\s*");
		StringBuilder sb = new StringBuilder();
		for (String phrase : phrases) {
			String[] words = phrase.split("\\PL+");
			Arrays.sort(words, Comparator.comparingInt(String::length));
			sb.append(String.join(" ", words)).append("\n");
		}
		return sb.toString();
	}

	private static String sortParagraphes(String text) {
		String[] paragraphes = text.split("\n");
		Arrays.sort(paragraphes, Comparator.comparingInt(s -> countClauses(s)));
		return String.join("\n", paragraphes);
	}

	private static int countClauses(String text) {
		Pattern pat = Pattern.compile("[.!?]+");
		Matcher mat = pat.matcher(text);
		int count = 0;
		while (mat.find())
			count++;
		return count;
	}

	private static int countCharacters(char ch, String word) {
		Pattern pat = Pattern.compile(String.valueOf(ch));
		Matcher mat = pat.matcher(word);
		int counter = 0;
		while (mat.find()) {
			counter++;
		}
		return counter;
	}

	private static void showMenu() {
		System.out.println("1 - �������� �������� �����");
		System.out.println("2 - ������������� ������ �� ���������� �����������");
		System.out.println("3 - � ������ ����������� ������������� ����� �� �����");
		System.out.println("4 - ������������� ������� � ����������� �� �������� ���������� ��������� ������� 'a', "
				+ "� � ������ ��������� � �� ��������");
		System.out.println("0 - �����");
		System.out.println("---------------------------------------------------------\n");
	}

}
