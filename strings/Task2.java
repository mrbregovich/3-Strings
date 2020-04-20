package by.mrbregovich.strings;

/*
 * В строке вставить после каждого символа 'a' символ 'b'.
 */

class Task2 {
	public static void main(String[] args) {
		String str = "aaaaaaaa";
		str = str.replaceAll("a", "ab");
		System.out.println(str);
	}
}
