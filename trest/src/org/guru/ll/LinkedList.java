package org.guru.ll;

public class LinkedList<T> {

	public Node<T> startNode;

	public Node<T> endNode;

	public LinkedList(Node<T> startNode) {
		this.startNode = startNode;
		endNode = startNode;
	}

	public void addNode(Node<T> node) {
		endNode.next = node;
		endNode = node;
	}

	@Override
	public String toString() {
		if (startNode == null) {
			return "|-|";
		}
		return startNode.toString();
	}
}