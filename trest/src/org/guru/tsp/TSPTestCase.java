package org.guru.tsp;

import org.guru.common.NNode;

public class TSPTestCase {

	public static NNode<Integer> wikiExample() {

		NNode<Integer> nd1 = new NNode<Integer>("Nd1");
		NNode<Integer> nd2 = new NNode<Integer>("Nd2");
		NNode<Integer> nd3 = new NNode<Integer>("Nd3");
		NNode<Integer> nd4 = new NNode<Integer>("Nd4");

		nd1.connect(20, nd2);
		nd1.connect(35, nd3);
		nd1.connect(42, nd4);

		nd2.connect(30, nd4);
		nd2.connect(34, nd3);

		nd3.connect(12, nd4);
		return nd1;
	}
}
