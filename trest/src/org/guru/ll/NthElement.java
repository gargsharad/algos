package org.guru.ll;

public class NthElement {

	public static void main(String[] args) {

		Node<Integer> start = new Node<Integer>(1);
		Node<Integer> tmp = start.next = new Node<Integer>(2);
		tmp = tmp.next = new Node<Integer>(3);
		tmp = tmp.next = new Node<Integer>(4);
		tmp = tmp.next = new Node<Integer>(5);
		tmp = tmp.next = new Node<Integer>(6);
		System.out.println(start);
		Counter cnt;
		Node<Integer> nThNode = getNthElement(start, cnt = new Counter(3));
		System.out.println(cnt.n+" n :" + nThNode.data);
	}

	public static class Counter {

		public int n;

		public Counter(int n) {
			super();
			this.n = n;
		}

	}

	private static Node<Integer> getNthElement(Node<Integer> node, Counter nCnt) {
		if (node == null) {
			return null;
		}
		
		Node<Integer> nThNode = getNthElement(node.next, nCnt);
		if (nThNode != null) {
			return nThNode;
		}

		if (nCnt.n == 1) {
			return node;
		}
		nCnt.n--;
		return null;
	}
}
