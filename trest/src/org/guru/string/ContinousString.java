package org.guru.string;

public class ContinousString {

	private static char[] str1 = "aaabbaaaccdeqjncsdddmmmkkkmmmddd"
			.toCharArray();// "abcrfghwetf".toCharArray();
	private static char[] str2 = new StringBuilder(
			"aaabbaaaccdeqjncsdddmmmkkkmmmddd").reverse().toString()
			.toCharArray();// abrfghwwetxyab".toCharArray();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int max = 0;
		String longestStr = "";

		String longestResults[][] = new String[str1.length + 1][str2.length + 1];

		for (int i = 0; i < str2.length; i++) {

			char str2char = str2[i];
			for (int j = 0; j < str1.length; j++) {
				if (longestResults[j][i] == null) {
					longestResults[j][i] = "";
				}
				if (str2char == str1[j]) {
					longestResults[j + 1][i + 1] = longestResults[j][i]
							+ str2char;
					if (longestResults[j + 1][i + 1].length() > max) {
						max = longestResults[j + 1][i + 1].length();
						longestStr = longestResults[j + 1][i + 1];
					}
				}
			}
		}

		System.out.println(max + " : " + longestStr);
		printArray(longestResults);

	}

	private static void printArray(Object[][] longestResults) {
		for (int i = 0; i < longestResults.length; i++) {
			for (int j = 0; j < longestResults[i].length; j++) {
				System.out.print(longestResults[i][j] + " -- ");
			}
			System.out.println("");
		}
	}
}
