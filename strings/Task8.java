package by.mrbregovich.strings;

import java.util.Comparator;
import java.util.stream.Stream;

/*
 * ¬водитс€ строка слов, разделенных пробелами. Ќайти самое длинное слово и вывести его на экран. 
 * —лучай, когда самых длинных слов может быть несколько, не обрабатывать.
 */

class Task8 {
	public static void main(String[] args) {
		String str = "Helloooooooo java woooorld";
		System.out.println(getMaxStringUsingStream(str));
	}

	private static String getMaxStringUsingStream(String str) {
		return Stream.of(str.strip().split(" ")).max(Comparator.comparing(String::length)).get();
	}
}
