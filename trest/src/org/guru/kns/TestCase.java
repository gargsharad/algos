package org.guru.kns;

public class TestCase {

	public static class Test1 {

		public static final int knapSackSize = 49;

		public static Sack[] sacks() {

			Sack sck1 = new Sack(2, 5);
			Sack sck2 = new Sack(3, 8);
			Sack sck3 = new Sack(5, 14);
			Sack[] sacks = new Sack[] { sck1, sck2, sck3 };

			return sacks;

		}
	}
}
