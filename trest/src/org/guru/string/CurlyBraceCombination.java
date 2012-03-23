package org.guru.string;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class CurlyBraceCombination {

	public static void main(String[] args) {

		int n = 3;

		String forOne = "{}";

		Set<String> allCombos = new LinkedHashSet<String>();
		allCombos.add(forOne);
		for (int i = 1; i < n; i++) {

			Set<String> newCombos = new LinkedHashSet<String>();
			for (Iterator<String> iterator = allCombos.iterator(); iterator
					.hasNext();) {
				String braceCombo = iterator.next();
				newCombos.add("{}" + braceCombo);
				newCombos.add(braceCombo + "{}");
				newCombos.add("{" + braceCombo + "}");
			}
			allCombos.clear();
			allCombos.addAll(newCombos);
		}

		System.out.println(allCombos);

	}
}
