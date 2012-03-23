package org.guru.tsp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.guru.common.NNode;
import org.guru.common.WEdge;

public class TSPBruteForce {

	private final NNode<Integer> startNode;

	private List<NNode<Integer>> visitedNode = new ArrayList<NNode<Integer>>();
	private List<NNode<Integer>> allNodes = new ArrayList<NNode<Integer>>();

	public TSPBruteForce(NNode<Integer> startNode) {
		super();
		this.startNode = startNode;

		visitAll(startNode);
		System.out.println("allNodes :" + allNodes);
	}

	private void visitAll(NNode<Integer> startNode) {
		allNodes.add(startNode);
		Iterator<WEdge<Integer>> references = startNode.references.iterator();
		while (references.hasNext()) {
			WEdge<Integer> edge = references.next();
			NNode<Integer> otherNode = edge.getOtherNode(startNode);
			if (!allNodes.contains(otherNode)) {
				visitAll(otherNode);
			}
		}
	}

	public class Path {

		public List<NNode<Integer>> nodes = new ArrayList<NNode<Integer>>();
		public List<WEdge<Integer>> edges = new ArrayList<WEdge<Integer>>();

		public Path() {
		}

		public Path(Path pathToCopy) {
			copy(pathToCopy);
		}

		public void copy(Path pathToCopy) {
			nodes.addAll(pathToCopy.nodes);
			edges.addAll(pathToCopy.edges);
		}

		public Integer totalDistance() {
			int sum = 0;
			for (WEdge<Integer> edge : edges) {
				sum += edge.data;
			}

			return sum;
		}

		public boolean isComplete() {
			return allNodes.size() == nodes.size();
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < nodes.size(); i++) {
				if (edges.size() == i) {
					sb.append(nodes.get(i));
				} else {
					sb.append(nodes.get(i) + " <--" + edges.get(i).data + "-->");
				}
			}
			return sb.toString();
		}
	}

	public Path computePath(NNode<Integer> startNode, Path existingPath) {
		if (existingPath == null)
			existingPath = new Path();
		Path localPath = new Path(existingPath);
		localPath.nodes.add(startNode);
		Iterator<WEdge<Integer>> edges = startNode.references.iterator();
		Integer shortest = null;
		Path shortestPath = null;
		while (edges.hasNext()) {
			WEdge<Integer> edge = edges.next();
			NNode<Integer> endNode = edge.getOtherNode(startNode);
			if (existingPath.nodes.contains(endNode)) {
				continue;
			}
			Path tempPath = new Path(localPath);
			tempPath.edges.add(edge);
			tempPath = computePath(endNode, tempPath);
			Integer distance = existingPath.totalDistance();
			if (shortest == null || shortest > distance) {
				shortest = distance;
				shortestPath = tempPath;
			}

		}
		if (shortestPath != null) {
			return shortestPath;
		}
		return localPath;

	}

	public class NodeVisitor {

		// private List<NNode<T>> nodesVisited = new
	}
}
