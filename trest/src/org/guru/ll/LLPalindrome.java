package org.guru.ll;

public class LLPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedList<Character> ls = new LinkedList<Character>(
				new Node<Character>('T'));
		ls.addNode(new Node<Character>('E'));
		ls.addNode(new Node<Character>('S'));
		ls.addNode(new Node<Character>('T'));
		ls.addNode(new Node<Character>('S'));
		ls.addNode(new Node<Character>('E'));
		ls.addNode(new Node<Character>('T'));


		StringBuffer revStr = new StringBuffer();
		StringBuffer fwdStr = new StringBuffer();

		boolean test = isPalindrome(ls.startNode, fwdStr, revStr);
		System.out.println(fwdStr + " : " + revStr + " : " + test);
	}

	private static boolean isPalindrome(Node<Character> startNode,
			StringBuffer fwdStr, StringBuffer revStr) {

		fwdStr.append(startNode.data);
		if (startNode.next != null) {
			isPalindrome(startNode.next, fwdStr, revStr);
		}
		revStr.append(startNode.data);
		return fwdStr.toString().equals(revStr.toString());

	}

}
