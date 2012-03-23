package org.guru.tree;

public interface IBinaryTreeNode<T> {

	public T data();

	public boolean dataEquals(IBinaryTreeNode<T> other);

	public void left(IBinaryTreeNode<T> leftNode);

	public void right(IBinaryTreeNode<T> rightNode);

	public IBinaryTreeNode<T> left();

	public IBinaryTreeNode<T> right();

}
