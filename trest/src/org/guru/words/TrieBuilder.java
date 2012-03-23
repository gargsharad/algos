package org.guru.words;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import org.guru.words.WordList.CharNode;

public class TrieBuilder {

	final CharNode root;
	int nodeCounter;
	int maxDepth;
	int totalWordsInTrie;
	TreeMap<Character, Integer> chCount = new TreeMap<Character, Integer>();

	public TrieBuilder(CharNode root) {
		super();
		this.root = root;

	}

	public void addWord(String word) {

		char[] charArray = word.toCharArray();
		addWord(charArray);
	}

	private void addWord(char[] charArray) {
		CharNode rootTmp = root;
		int depth = 0;
		for (int i = 0; i < charArray.length; i++) {
			CharNode charNode = rootTmp.charNodeMap.get(charArray[i]);
			if (charNode == null) {
				charNode = new CharNode(charArray[i]);
				nodeCounter++;
				rootTmp.add(charNode);
				depth++;
				Integer cnt = chCount.get(charArray[i]);
				if (cnt == null) {
					cnt = 0;
				}
				chCount.put(charArray[i], ++cnt);
			}

			if (i == charArray.length - 1) {
				charNode.isEndWordNode = true;
				totalWordsInTrie++;
			}
			rootTmp = charNode;
		}
		if (depth > maxDepth) {
			maxDepth = depth;
		}
	}

	public void printTree(CharNode nd, int level) {
		System.out.println(getSpace(level) + nd + "(" + level + ")");
		Iterator<CharNode> children = nd.charNodeMap.values().iterator();
		level++;
		while (children.hasNext()) {
			CharNode child = children.next();
			printTree(child, level);
		}

	}

	private String getSpace(int level) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < level; i++) {
			s.append("   ");
		}
		return s.toString();
	}

	public void print() {

		int level = 1;
		CharNode LEVEL_ENDER = new CharNode('\n');

		Queue<CharNode> q = new LinkedList<CharNode>();
		q.add(root);
		q.add(LEVEL_ENDER);
		while (!q.isEmpty()) {
			CharNode node = remove(q);

			if (node == LEVEL_ENDER) {
				System.out.println("\n* " + level);
				level++;
				if (!q.isEmpty()) {
					q.add(LEVEL_ENDER);
				}
				continue;
			}
			System.out.print(node + " ");
			q.addAll(node.charNodeMap.values());
		}
		System.out.println("");
	}

	private CharNode remove(Queue<CharNode> q) {
		try {
			return q.remove();
		} catch (Exception ee) {
			return null;
		}
	}
}
