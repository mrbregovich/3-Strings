package by.mrbregovich.charArrays;

/*
 * Замените в строке все вхождения 'word' на 'letter'
 */

class Task2 {
	public static void main(String[] args) {
		String source = "Print word, write word, check word!";
		String oldStr = "word";
		String newStr = "letter";
		source = replaceAllEntries(source, oldStr, newStr);
		System.out.println(source);
	}

	private static String replaceAllEntries(String sourceStr, String oldStr, String newStr) {
		char[] srcStrArr = sourceStr.toCharArray();
		char[] oldStrArr = oldStr.toCharArray();
		char[] newStrArr = newStr.toCharArray();
		int ind = getIndexOfWord(srcStrArr, oldStrArr, 0);
		while (ind != -1) {
			char[] temp = new char[srcStrArr.length - oldStrArr.length + newStrArr.length];
			System.arraycopy(srcStrArr, 0, temp, 0, ind);
			System.arraycopy(newStrArr, 0, temp, ind, newStrArr.length);
			System.arraycopy(srcStrArr, ind + oldStrArr.length, temp, ind + newStrArr.length,
					srcStrArr.length - ind - oldStrArr.length);
			srcStrArr = temp;
			ind = getIndexOfWord(srcStrArr, oldStrArr, ind + newStrArr.length);

		}
		return String.valueOf(srcStrArr);
	}

	private static int getIndexOfWord(char[] source, char[] target, int startInd) {
		int index = -1;
		for (int i = startInd; i < source.length - target.length; i++) {
			if (source[i] == target[0]) {
				index = i;
				int k = i + 1;
				for (int j = 1; j < target.length; j++) {
					if (target[j] != source[k++]) {
						index = -1;
						break;
					}
				}
			}
			if (index != -1)
				break;
		}
		return index;
	}
}
