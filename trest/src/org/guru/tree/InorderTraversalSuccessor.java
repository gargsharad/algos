package org.guru.tree;

public class InorderTraversalSuccessor {

	private static IBinaryTreeNode<Integer> lastMaxNode = null;

	public static void main(String[] args) {

		IBinaryTreeNode<Integer> root = createExampleBST();
		IBinaryTreeNode<Integer> foundNext = new TreeNode<Integer>(25);
		do {
			lastMaxNode = null;
			IBinaryTreeNode<Integer> toFind = foundNext;
			foundNext = findInorderSuccessor(foundNext, root);
			System.out.println(toFind+" found Next : " + foundNext);
		} while (foundNext != null);

	}

	private static IBinaryTreeNode<Integer> findInorderSuccessor(
			IBinaryTreeNode<Integer> requiredTreeNode,
			IBinaryTreeNode<Integer> root) {

		if (root == null)
			return null;

		if (requiredTreeNode.dataEquals(root)) {
			if (root.right() != null) {
				return leftMost(root.right());
			}
			return lastMaxNode;
		}

		if (root.data() < requiredTreeNode.data()) {
			return findInorderSuccessor(requiredTreeNode, root.right());
		}

		lastMaxNode = root;
		return findInorderSuccessor(requiredTreeNode, root.left());
	}

	private static IBinaryTreeNode<Integer> leftMost(IBinaryTreeNode<Integer> nd) {
		if (nd == null) {
			return null;
		}
		if (nd.left() == null) {
			return nd;
		}
		return leftMost(nd.left());
	}

	private static IBinaryTreeNode<Integer> createExampleBST() {
		IBinaryTreeNode<Integer> root = new TreeNode<Integer>(100);

		root.left(new TreeNode<Integer>(50));
		root.right(new TreeNode<Integer>(120));

		root.left().left(new TreeNode<Integer>(25));
		root.left().right(new TreeNode<Integer>(75));

		root.left().right().left(new TreeNode<Integer>(65));

		root.left().right().left().left(new TreeNode<Integer>(60));
		root.left().right().left().right(new TreeNode<Integer>(70));

		root.left().right().left().right().right(new TreeNode<Integer>(71));

		return root;
	}
}
