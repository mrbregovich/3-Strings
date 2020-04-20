package by.mrbregovich.strings;

/*
 * С помощью функции копирования и операции конкатенации составить из частей слова 
 * “информатика” слово “торт”.
 */

class Task4 {
	public static void main(String[] args) {
		String source = "информатика";
		String result = "";
		int tInd = source.indexOf("т");
		int orInd = source.indexOf("ор");
		result = source.substring(tInd, tInd + 1) + source.substring(orInd, orInd + 2)
				+ source.substring(tInd, tInd + 1);
		System.out.println(result);
	}
}
