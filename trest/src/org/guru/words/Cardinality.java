package org.guru.words;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class Cardinality {

	public static void main(String[] args) throws Throwable {
		WordMap mp = new WordMap();
		mp.addWord("guru".toCharArray());
		mp.addWord("prasad".toCharArray());
		mp.addWord("prasad".toCharArray());
		mp.addWord("guru".toCharArray());
		mp.addWord("gu".toCharArray());

		BufferedReader reader = new BufferedReader(new FileReader(
				"e:/gyan/shakespeare.txt"));
		for (String line = reader.readLine(); line != null; line = reader
				.readLine()) {
			String[] words = line.trim().split(" ");
			for (int i = 0; i < words.length; i++) {
				mp.addWord(words[i].trim().toCharArray());
			}

		}
		System.out.println(":" + mp.cardinality);
		System.out.println("nodes " + mp.nodes);
	}

	private static class WordMap {

		CharNode root = new CharNode('#');
		int cardinality;
		int nodes = 0;

		public void addWord(char[] wordArr) {
			if (wordArr.length == 0) {
				return;
			}
			CharNode current = root;
			for (int i = 0; i < wordArr.length; i++) {

				if (current.children.containsKey(wordArr[i])) {
					current = current.children.get(wordArr[i]);
					if (i == wordArr.length - 1 && !current.eow) {
						current.eow = true;
						cardinality++;
					}
				} else {
					CharNode ch = new CharNode(wordArr[i]);
					nodes++;
					current.children.put(wordArr[i], ch);
					current = ch;
					if (i == wordArr.length - 1) {
						ch.eow = true;
						cardinality++;
					}
				}
			}
		}
	}

	private static class CharNode {
		public boolean eow;
		char c;

		public CharNode(char c) {
			this.c = c;
		}

		HashMap<Character, CharNode> children = new HashMap<Character, Cardinality.CharNode>();
	}
}
