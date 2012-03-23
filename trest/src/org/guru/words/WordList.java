package org.guru.words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class WordList {

	public static class CharNode {

		public char ch;
		public boolean isEndWordNode = false;

		public HashMap<Character, CharNode> charNodeMap = new HashMap<Character, WordList.CharNode>();

		public CharNode(char c) {
			this.ch = c;
		}

		public void add(CharNode node) {
			charNodeMap.put(node.ch, node);
		}

		@Override
		public String toString() {

			return ch + "";
		}

		@Override
		public int hashCode() {

			return (int) ch;
		}

	}

	public static void main(String a[]) throws IOException {

		CharNode root = new CharNode('#');
		TrieBuilder builder = new TrieBuilder(root);
		BufferedReader reader = new BufferedReader(new FileReader(
				"C:/Users/ggv/Downloads/enable1.txt"));

		long start = System.currentTimeMillis();
		int i =0 ;
		for (String word = reader.readLine(); word != null; word = reader
				.readLine()) {

			// System.out.println(word);
			builder.addWord(word);
			i++;
		}
		long end = System.currentTimeMillis();
		System.out.println(" building trie :: " + (end - start));
		System.out.println(" LL word "+i);
		System.out.println(" node count " + builder.nodeCounter);
		System.out.println(" node count per char " + builder.chCount);
		System.out.println(" trie max Depth " + builder.maxDepth);
		System.out.println(" trie total words " + builder.totalWordsInTrie);
		builder.printTree(root, 0);

		suggestFor(root, "zeal");

		//justHangForAWhile(root);

	}

	private static void justHangForAWhile(CharNode root) {
		while (true) {
			System.out.println("waint " + root);
			try {
				Thread.sleep(40000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void suggestFor(CharNode trieRoot, String string) {
		long start = System.currentTimeMillis();
		CharNode leaf = getLeafOfWord(trieRoot, string);
		long end = System.currentTimeMillis();
		System.out.println(" findingLeaf :: " + (end - start));
		if (leaf != null)
			if (leaf.isEndWordNode) {
				System.out.println(" Found complete Word : " + leaf + " = "
						+ leaf.isEndWordNode);
			} else {
				System.out.println(" Found partial Word : " + leaf + " = "
						+ leaf.isEndWordNode);
			}
		else {
			System.out.println(" Not found " + string);
		}

		ArrayList<String> resultForSuggestions = new ArrayList<String>();
		start = System.currentTimeMillis();
		getAllSuggestions(resultForSuggestions, string, leaf);
		end = System.currentTimeMillis();
		System.out.println(resultForSuggestions + "\n in " + (end - start)
				+ " ms");
	}

	private static void getAllSuggestions(ArrayList<String> arrayList,
			String origString, CharNode root) {
		Collection<CharNode> allLeaves = root.charNodeMap.values();

		for (Iterator<CharNode> iterator = allLeaves.iterator(); iterator
				.hasNext();) {
			CharNode charNode = iterator.next();
			if (charNode.isEndWordNode) {
				arrayList.add(origString + charNode.ch);
			}
			getAllSuggestions(arrayList, origString + charNode.ch, charNode);

		}
	}

	private static CharNode getLeafOfWord(CharNode trieRoot, String string) {
		char[] charArr = string.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			trieRoot = trieRoot.charNodeMap.get(charArr[i]);
			if (trieRoot == null) {
				return null;
			}
		}
		return trieRoot;
	}
}
