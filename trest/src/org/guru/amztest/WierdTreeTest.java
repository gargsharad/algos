package org.guru.amztest;

public class WierdTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node bsTreeRoot = constructBSTreeExample();
		TreeWierdizer wr = new TreeWierdizer(bsTreeRoot);
		wr.start();
		System.out.println( " done");
	}

	private static Node constructBSTreeExample() {
		Node root = new Node(10);
		Node tmp = root.addLeft(new Node(2));
		tmp.addLeft(new Node(1));
		tmp.addRight(new Node(3));

		tmp = root.addRight(new Node(15));
		tmp.addLeft(new Node(14));
		return root;
	}

	private static Node constructWierdTreeExample(Node bstRoot) {
		Node wTree = null;
		Node leftNode = bstRoot.getLeft();
		Node rightNode = bstRoot.getRight();

		if (leftNode == null && rightNode == null) {

		}

		else if (rightNode == null) {

		}
		return wTree;
	}

	@SuppressWarnings("unused")
	private static Node postOrderVisit(Node root) {
		if (root == null) {
			return null;
		}
		Node leftNd = postOrderVisit(root.getLeft());
		Node rightNd = postOrderVisit(root.getRight());
		if (leftNd == null && rightNd == null) {
			return new Node(root);
		} else if (rightNd == null) {
			leftNd.setData(root.getData());
			return new Node(root);
		} else if (leftNd == null) {
			Node newRoot = new Node(root);
			newRoot.setData(rightNd.getData());
			return newRoot;
		} else {
			Node nd = new Node(leftNd.getData() + rightNd.getData());
			return nd;
		}
	}

	private static Node visit(Node root) {
		Node nd = new Node(root);
		return nd;
	}

}
