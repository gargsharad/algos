package org.guru.tree;

public class CommonAncestorBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IBinaryTreeNode<Integer> root = createExampleBST();
		{
			IBinaryTreeNode<Integer> node = commonAncestor(root,
					new TreeNode<Integer>(25), new TreeNode<Integer>(71), null);
			System.out.println(" node " + node);
		}
		{
			IBinaryTreeNode<Integer> node = commonAncestor(root,
					new TreeNode<Integer>(50), new TreeNode<Integer>(25), null);
			System.out.println(" node " + node);
		}
		{
			IBinaryTreeNode<Integer> node = commonAncestor(root,
					new TreeNode<Integer>(120), new TreeNode<Integer>(25), null);
			System.out.println(" node " + node);
		}
		{
			IBinaryTreeNode<Integer> node = commonAncestor(root,
					new TreeNode<Integer>(50), new TreeNode<Integer>(100), null);
			System.out.println(" node " + node);
		}
		
		{
			IBinaryTreeNode<Integer> node = commonAncestor(root,
					new TreeNode<Integer>(50), new TreeNode<Integer>(110), null);
			System.out.println(" node " + node);
		}
	}

	private static IBinaryTreeNode<Integer> commonAncestor(
			IBinaryTreeNode<Integer> root, IBinaryTreeNode<Integer> nd1,
			IBinaryTreeNode<Integer> nd2, IBinaryTreeNode<Integer> lastParent) {

		if (nd1.data() < root.data() && nd2.data() < root.data()) {
			return commonAncestor(root.left(), nd1, nd2, root);
		}

		if (nd1.data() > root.data() && nd2.data() > root.data()) {
			return commonAncestor(root.right(), nd1, nd2, root);
		}

		if (nd1.dataEquals(root) || nd2.dataEquals(root)) {
			return lastParent;
		}

		return exists(nd1, root) && exists(nd2, root) ? root : null;

	}

	private static boolean exists(IBinaryTreeNode<Integer> nd1,
			IBinaryTreeNode<Integer> root) {
		if (root == null) {
			return false;
		}
		if (nd1.dataEquals(root)) {
			return true;
		}
		if (nd1.data() < root.data()) {
			return exists(nd1, root.left());
		}
		return exists(nd1, root.right());
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
