package org.guru.common;

import java.util.ArrayList;
import java.util.List;

public class NNode<T> {

	public final String nodeId;
	public NNode(String nodeId) {
		super();
		this.nodeId = nodeId;
	}

	public T data;

	public List<WEdge<T>> references = new ArrayList<WEdge<T>>();

	public WEdge<T> connect(T data, NNode<T> otherNode) {

		WEdge<T> edge = new WEdge<T>(data, this, otherNode);
		references.add(edge);
		otherNode.references.add(edge);
		return edge;
	}

	@Override
	public String toString() {
		return nodeId+"["+data+"]";
	}
}
