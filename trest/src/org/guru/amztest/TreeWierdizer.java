package org.guru.amztest;

public class TreeWierdizer {

	private final Node rootNode;

	public TreeWierdizer(Node rootNode) {
		super();
		this.rootNode = rootNode;
	}

	public synchronized Node start() {

		incBottomUp(rootNode);

		return rootNode;
	}

	private void incBottomUp(Node nd) {

		if (nd == null) {
			return;
		}
		incBottomUp(nd.getLeft());
		incBottomUp(nd.getRight());

		if (nd.getLeft() == null && nd.getRight() != null) {
			nd.setData(nd.getRight().getData());
		}

		if (nd.getLeft() != null && nd.getRight() == null) {
			nd.getLeft().setData(nd.getData());
			fixNodeTopTown(nd.getLeft());
		}

		if (nd.getLeft() != null && nd.getRight() != null) {
			nd.setData(nd.getRight().getData() + nd.getLeft().getData());
		}

	}

	private void fixNodeTopTown(Node nd) {
		if (nd != null) {
			
			int apparentLeft = nd.getLeft() != null ? nd.getLeft().getData() : 0;
			int apparentRight = nd.getRight() != null ? nd.getRight().getData() : 0;
			
			if (nd.getRight() != null ) {
				nd.getRight().setData(nd.getData() - apparentLeft);
				fixNodeTopTown(nd.getRight());
			} else if(nd.getLeft() != null){
				nd.getLeft().setData(nd.getData() - apparentRight);
				fixNodeTopTown(nd.getRight());
			}
						
		}

	}

}
