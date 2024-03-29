package org.guru.ll;

public class Node<T> {
	public T data;
	public Node<T> next;

	public Node(T data) {
		super();
		this.data = data;
	}

	public Node(T data, Node<T> next) {
		super();
		this.data = data;
		this.next = next;
	}

	@Override
	public String toString() {
		return data + (next == null ? "->#" : ("->" + next));
	}
}