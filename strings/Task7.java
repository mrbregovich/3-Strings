package by.mrbregovich.strings;

/*
 * Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. 
 * Например, если было введено "abc cdedef", то должно быть выведено "abcdef".
 */

class Task7 {
	public static void main(String[] args) {
		String str = "abc cdedef";
		System.out.println(refactorString(str));
	}

	private static String refactorString(String str) {
		StringBuilder sb = new StringBuilder();
		str.chars().distinct().filter(ch -> ch != ' ').forEach(ch -> sb.append((char) ch));
		return sb.toString();
	}
}
