package org.guru.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	static final TreeNode<Integer> LEVEL_ENDER = new TreeNode<Integer>(null);

	public static void main(String[] args) {
		TreeNode<Integer> root = buildGenericTreeExample();
		levelOrderTraveverse(root);
	}

	private static void levelOrderTraveverse(TreeNode<Integer> root) {

		Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
		q.add(root);
		q.add(LEVEL_ENDER);
		while (!q.isEmpty()) {

			TreeNode<Integer> curr = q.remove();
			if (curr == LEVEL_ENDER) {
				System.out.println("\n ---- ---- ----");
				if (!q.isEmpty())
					q.add(LEVEL_ENDER);

				continue;
			}
			System.out.print(curr.data + " ");
			Iterator<TreeNode<Integer>> itr = curr.children();
			while ((itr).hasNext()) {
				TreeNode<Integer> child = itr.next();
				q.add(child);
			}
		}

	}

	private static TreeNode<Integer> buildGenericTreeExample() {

		TreeNode<Integer> root = new TreeNode<Integer>(1);
		TreeNode<Integer> ch1 = root.addChild(new TreeNode<Integer>(2));
		TreeNode<Integer> ch2 = root.addChild(new TreeNode<Integer>(3));
		ch1.addChild(new TreeNode<Integer>(4));
		ch1.addChild(new TreeNode<Integer>(5));
		ch1.addChild(new TreeNode<Integer>(6));
		ch2.addChild(new TreeNode<Integer>(7));
		ch2.addChild(new TreeNode<Integer>(8));

		return root;
	}
}
