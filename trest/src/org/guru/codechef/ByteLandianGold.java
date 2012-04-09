package org.guru.codechef;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * In Byteland they have a very strange monetary system. Each Bytelandian gold
 * coin has an integer number written on it. A coin n can be exchanged in a bank
 * into three coins: n/2, n/3 and n/4. But these numbers are all rounded down
 * (the banks have to make a profit). You can also sell Bytelandian coins for
 * American dollars. The exchange rate is 1:1. But you can not buy Bytelandian
 * coins. You have one gold coin. What is the maximum amount of American dollars
 * you can get for it? Input
 * 
 * The input will contain several test cases (not more than 10). Each testcase
 * is a single line with a number n, 0 <= n <= 1 000 000 000. It is the number
 * written on your coin. Output
 * 
 * For each test case output a single line, containing the maximum amount of
 * American dollars you can make. Example
 * 
 * Input: 12 2
 * 
 * Output: 13 2
 * 
 * You scan change 12 into 6, 4 and 3, and then change these into $6+$4+$3 =
 * $13. If you try changing the coin 2 into 3 smaller coins, you will get 1, 0
 * and 0, and later you can get no more than $1 out of them. It is better just
 * to change the 2 coin directly into $2.
 * 
 * @author ggv
 * 
 */
public class ByteLandianGold {

	public static void main(String[] args) throws IOException {

		java.io.BufferedReader r = new java.io.BufferedReader(
				new java.io.InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String s;
		while ((s = r.readLine()) != null && !s.trim().equals("")) {
			int startingCoin = Integer.parseInt(s);
			int max = exchangeBankMax(startingCoin);
			pw.println(max);
		}

	}

	private static int exchangeBankMax(int coin) {
		int afterDiv = coin / 2 + coin / 3 + coin / 4;
		if (afterDiv > coin) {
			afterDiv = exchangeBankMax(coin / 2) + exchangeBankMax(coin / 3)
					+ exchangeBankMax(coin / 4);
			return afterDiv;
		}
		return coin;
	}
}
