package org.guru.common;

public class WEdge<T> {

	public final T data;
	private final NNode<T> nd1;
	private final NNode<T> nd2;

	public WEdge(T data, NNode<T> nd1, NNode<T> nd2) {
		super();
		this.data = data;
		this.nd1 = nd1;
		this.nd2 = nd2;
	}

	public NNode<T> getOtherNode(NNode<T> thisNode) {

		if (nd1 == thisNode) {
			return nd2;
		}
		return nd1;
	}

}
