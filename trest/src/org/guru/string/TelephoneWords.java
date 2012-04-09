package org.guru.string;

import java.util.ArrayList;
import java.util.List;

public abstract class TelephoneWords {

	static char[][] keyPad = { "0".toCharArray(), "1".toCharArray(), "abc".toCharArray(),
			"def".toCharArray(), "ghi".toCharArray(), "jkl".toCharArray(),
			"mno".toCharArray(), "pqrs".toCharArray(), "tuv".toCharArray(),
			"wxyz".toCharArray() };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int phone[] = { 9, 8, 4, 4, 2, 1, 1, 4, 0, 1 };

		List<String> words = permuteWords(phone, 0);
		System.out.println(words.size());
		for(String w : words){
			System.out.println(w);
		}
	}

	private static List<String> permuteWords(int[] phone, int start) {

		List<String> words = new ArrayList<String>();

		if (start == phone.length - 1) {

			char[] keyPadAlphas = keyPad[phone[start]];
			for (int i = 0; i < keyPadAlphas.length; i++) {
				words.add(keyPadAlphas[i] + "");
			}
			return words;
		}

		char[] keyPadAlphas = keyPad[phone[start]];
		for (int i = 0; i < keyPadAlphas.length; i++) {

			List<String> chWords = permuteWords(phone, start + 1);
			for (String ch : chWords) {
				words.add(keyPadAlphas[i] + ch);
			}

		}

		return words;
	}

}
