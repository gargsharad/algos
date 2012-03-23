package org.guru.tsp;

import org.guru.common.NNode;
import org.guru.tsp.TSPBruteForce.Path;

public class TSPMain {

	public TSPMain() {

		NNode<Integer> startNode = TSPTestCase.wikiExample();
		TSPBruteForce bf = new TSPBruteForce(startNode);
		Path path = bf.computePath(startNode, null);
		System.out.println(" PATH " + path);

	}

	public static void main(String[] args) {
		new TSPMain();
	}
}
