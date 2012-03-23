package org.guru.amztest;

public class Node {

	private int data;
	private Node left;
	private Node right;

	public Node(int data) {
		this.setData(data);
	}

	public Node(Node dataNode) {
		this.setData(dataNode.getData());
	}

	public Node getLeft() {
		return left;
	}

	public Node addLeft(Node left) {

		this.left = left;
		return this.left;
	}

	public Node getRight() {
		return right;
	}

	public Node addRight(Node right) {
		this.right = right;
		return this.right;
	}

	public int getData() {
		return data;
	}

	/**
	 * returns weather the data was modified or not
	 * 
	 * @param data
	 * @return
	 */
	public boolean setData(int data) {
		boolean dataDifferent = (data != this.data);
		this.data = data;
		return dataDifferent;
	}

}