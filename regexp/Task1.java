package by.mrbregovich.regexp;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.*;

/*
 * Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом 
 * три различных операции: 
 * - отсортировать абзацы по количеству предложений; 
 * - в каждом предложении отсортировать слова по длине;
 * - отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, 
 * а в случае равенства – по алфавиту.
 */

class Task1 {
	public static void main(String[] args) {
		String text = "Ядром контейнера внедрения зависимостей в Spring служит интерфейс Bean Factory, "
				+ "который отвечает за управление компонентами Spring Beans, в том числе их зависимостями "
				+ "и жизненными циклами. Термин компонент Spring Bean употребляется в Spring для "
				+ "обозначения любого компонента, управляемого контейнером. Как правило, компоненты "
				+ "Spring Beans придерживаются на определенном уровне спецификации компонентов "
				+ "JavaBeans, хотя это совсем не обязательно, особенно если для связывания "
				+ "компонентов Spring Beans друг с другом предполагается применять внедрение "
				+ "зависимостей через конструктор. Еще одно предложение для проверки! Hello world.\nЕсли в приложении требуется лишь поддержка внедрения "
				+ "зависимостей, то с контейнером внедрения зависимостей в Spring можно взаимодействовать "
				+ "через интерфейс BeanFactory. В этом случае в приложении необходимо создать "
				+ "экземпляр класса, реализующего интерфейс BeanFactory, и сконфигурировать его на "
				+ "основании сведений о компонентах Spriпg Beans и зависимостях. Как только это будет "
				+ "сделано, компоненты Spriпg Beans могут быть доступны в приложении через интерфейс "
				+ "BeanFactory для последующей обработки.\nВ ряде случаев вся подобного рода настройка "
				+ "производится автоматически. Но зачастую программировать настройку "
				+ "приходится вручную. Во всех примерах, приведенных далее в этой главе, требуется "
				+ "ручная настройка реализации интерфейса BeanFactory.";
		String choice = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (!choice.equals("0")) {
			showMenu();
			System.out.print("Введите значение: ");
			try {
				choice = br.readLine();
			} catch (IOException e) {
				System.out.println("Некорректный ввод");
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
				System.out.println("Некорректный ввод");
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
			Arrays.sort(words, Comparator.comparingInt((String word) -> countCharacters('а', word)).reversed()
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
		System.out.println("1 - показать исходный текст");
		System.out.println("2 - отсортировать абзацы по количеству предложений");
		System.out.println("3 - в каждом предложении отсортировать слова по длине");
		System.out.println("4 - отсортировать лексемы в предложении по убыванию количества вхождений символа 'a', "
				+ "а в случае равенства – по алфавиту");
		System.out.println("0 - выход");
		System.out.println("---------------------------------------------------------\n");
	}

}
