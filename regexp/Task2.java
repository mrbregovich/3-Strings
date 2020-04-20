package by.mrbregovich.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Дана строка, содержащая текст (xml-документ)
 * Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип 
 * (открывающий тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами 
 * XML для решения данной задачи нельзя.
 */

class Task2 {
	public static void main(String[] args) {
		String text = "<notes>\n" + "<note id = \"1\">\n" + "<to>Вася</to>\n" + "<from>Света</from>\n"
				+ "<heading>Напоминание</heading>\n" + "<body>Позвони мне завтра!</body>\n" + "</note>\n"
				+ "<note id = \"2\">\n" + "<to>Петя</to>\n" + "<from>Маша</from>\n"
				+ "<heading>Важное напоминание</heading>\n" + "<body/>\n" + "</note>\n" + "</notes>";
		Pattern openningTag = Pattern.compile("<[\\w\\s=\"]+?>");
		Pattern closingTag = Pattern.compile("</[\\w]+?>");
		Pattern contentTag = Pattern.compile("(<[\\w\\s=\"]+?>)(.+?)(</[\\w]+?>)");
		Pattern noBodyTag = Pattern.compile("<[\\w\\s=\"]+?/>");
		String[] lines = text.split("\n");
		Matcher matcher = null;
		for (String line : lines) {
			matcher = openningTag.matcher(line);
			if (matcher.matches()) {
				System.out.println("Открывающий тег: " + line);
			}
			matcher = closingTag.matcher(line);
			if (matcher.matches())
				System.out.println("Закрывающий тег: " + line);
			matcher = noBodyTag.matcher(line);
			if (matcher.matches())
				System.out.println("Тег без тела: " + line);
			matcher = contentTag.matcher(line);
			if (matcher.matches()) {
				System.out.println("Открывающий тег: " + matcher.group(1));
				System.out.println("Содержимое тега: " + matcher.group(2));
				System.out.println("Закрывающий тег: " + matcher.group(3));
			}
		}
	}

}
