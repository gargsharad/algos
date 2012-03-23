package org.guru.ll;

/**
 * given 2 linked lists of unequal lengths,containing a single digited number in
 * each of their nodes. i was asked to build a 3rd linked list which contains
 * the sum of the two linked lists, again in the form of 1 digit in a node. ex:
 * linked list 1 is 4-7-9-6 linked list 2 is 5-7 then the 3rd linked list would
 * be 4-8-5-3
 * 
 */
public class LinkedListSum {

	public static void main(String[] args) {
		LinkedListSum test = new LinkedListSum();
		testDataPrep(test);
		test.run();
		System.out.println(" ");

	}

	private void run() {
		System.out.println(" P    " + p);
		System.out.println(" Q " + q);

		reverse(p);
		/*
		 * AddResult result = getAddResult(p.startNode, q.startNode);
		 * System.out.println(" res " + result.lastNode);
		 */
	}

	public void reverse(LinkedList ll) {

		Node nd = getNode(ll.startNode);
		nd.next = null;
		ll.startNode = ll.endNode;
		ll.endNode = nd;
		System.out.println(ll.startNode);
	}

	private Node getNode(Node nd) {
		System.out.println(nd.data);
		if (nd.next == null) {
			return nd;
		}
		Node<Integer> nextNode = getNode(nd.next);
		nextNode.next = nd;
		return nd;
	}

	private AddResult getAddResult(Node<Integer> pNode, Node<Integer> qNode) {

		AddResult res = null;
		if (pNode.next == null && qNode.next == null) {
			res = new AddResult(pNode, qNode);
		} else if (pNode.next == null) {
			res = getAddResult(pNode, qNode.next);
		} else if (qNode.next == null) {
			res = getAddResult(pNode.next, qNode);
		} else {
			res = getAddResult(pNode.next, qNode.next);
			res = res.add(pNode, qNode);
		}

		System.out.println(" p " + pNode.data + " : " + qNode.data);
		System.out.println(" return " + res.sumDigit + " (" + res.carry + ")");

		return res;
	}

	private LinkedList<Integer> q;
	private LinkedList<Integer> p;

	private static void testDataPrep(LinkedListSum test) {

		test.p = new LinkedList<Integer>(new Node<Integer>(7));
		test.p.addNode(new Node<Integer>(8));
		test.p.addNode(new Node<Integer>(6));

		test.q = new LinkedList<Integer>(new Node<Integer>(2));
		test.q.addNode(new Node<Integer>(4));
		test.q.addNode(new Node<Integer>(3));
		test.q.addNode(new Node<Integer>(7));
	}

	public static class AddResult {
		int carry = 0;
		int sumDigit;
		Node lastNode;

		public AddResult() {

		}

		public AddResult(Node<Integer> n1, Node<Integer> n2) {
			int sum = n1.data + n2.data;
			if (sum >= 10) {
				sumDigit = sum - 10;
				carry = 1; // anyway n1.data and n2.data are single digits
			}
			lastNode = new Node<Integer>(sumDigit, lastNode);
		}

		public AddResult add(Node<Integer> n1, Node<Integer> n2) {
			AddResult res = new AddResult();

			int sum = n1.data + n2.data + carry;
			if (sum >= 10) {
				res.carry = 1;
				res.sumDigit = sum - 10;
			}
			res.lastNode = new Node<Integer>(sumDigit, lastNode);
			return res;
		}
	}

}
