package org.guru.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeNode<T> implements IBinaryTreeNode<T> {

	public T data;

	private List<TreeNode<T>> children = new ArrayList<TreeNode<T>>();

	public TreeNode(T data) {
		this.data = data;
	}

	public TreeNode<T> addChild(TreeNode<T> node) {
		children.add(node);
		return node;
	}

	public Iterator<TreeNode<T>> children() {
		return children.iterator();
	}

	@Override
	public void left(IBinaryTreeNode<T> leftNode) {
		if (children.size() > 1)
			children.remove(0);
		children.add(0, (TreeNode<T>) leftNode);
	}

	@Override
	public void right(IBinaryTreeNode<T> rightNode) {
		if (children.size() > 2)
			children.remove(1);
		if (children.size() == 0) {
			children.add(0, null);
		}
		children.add(1, (TreeNode<T>) rightNode);
	}

	@Override
	public IBinaryTreeNode<T> left() {
		if (children.size() < 1) {
			return null;
		}
		return children.get(0);
	}

	@Override
	public IBinaryTreeNode<T> right() {
		if (children.size() < 2) {
			return null;
		}
		return children.get(1);
	}

	@Override
	public T data() {
		return data;
	}

	@Override
	public String toString() {
		return "[" + data + "]";
	}

	@Override
	public boolean dataEquals(IBinaryTreeNode<T> other) {

		return data.equals(other.data());
	}
}
