package org.guru.string;

import java.util.ArrayList;
import java.util.List;

public class PermuteAll {

	public static void main(String[] args) {

		char[] chars = "abcd".toCharArray();
		List<String> permutes = permute(chars);
		System.out.println(permutes);
		System.out.println(permutes.size());
	}

	private static List<String> permute(char[] chars) {

		List<String> ls = new ArrayList<String>();
		if (chars.length == 1) {
			ls.add(chars[0] + "");
			return ls;
		}

		for (int i = 0; i < chars.length; i++) {
			List<String> chLs = permute(remove(chars, chars[i]));
			for (String ch : chLs) {
				ls.add(chars[i] + ch);
			}
			
		}
		return ls;
	}

	private static char[] remove(char[] chars, char c) {

		char[] newChars = new char[chars.length - 1];
		int j = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != c) {
				newChars[j++] = chars[i];
			}
		}
		return newChars;
	}
}
