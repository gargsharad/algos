package org.guru.kns;

public class KNSolver {

	private final Sack[] sacks;
	private final int totalKnSize;

	public KNSolver(Sack[] sacks, int knSize) {
		super();
		this.sacks = sacks;
		this.totalKnSize = knSize;
	}

	public static void main(String[] args) {

		KNSolver kns = new KNSolver(TestCase.Test1.sacks(),
				TestCase.Test1.knapSackSize);

		int cost = kns.maxCost(kns.totalKnSize, kns.sacks.length);
		System.out.println(" COST " + cost);

	}

	private int maxCost(int knSize, int noOfSacksToChoose) {
		if (knSize <= 0 || noOfSacksToChoose == 0) {
			return 0;
		}

		int valueOfLastSack = sacks[noOfSacksToChoose - 1].value;
		int costOfLastSack = sacks[noOfSacksToChoose - 1].cost;
		int maxCost = max(maxCost(knSize, noOfSacksToChoose - 1),
				maxCost(knSize - costOfLastSack, noOfSacksToChoose)
						+ valueOfLastSack);
		System.out.println(" Calculating -> C(" + knSize + "," + noOfSacksToChoose
				+ ") = " + maxCost);
		return maxCost;
	}

	private int max(int i, int j) {
		return i > j ? i : j;
	}
}
