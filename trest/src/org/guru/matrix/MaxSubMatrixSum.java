package org.guru.matrix;

public class MaxSubMatrixSum {

	static int matrix[][] = //
	{ //
	{ 1, -1, 5, 8 }, //
			{ 0, -8, 6, -4 }, //
			{ 0, 10, -1, 1 }, //
			{ 4, -3, 1, -1 }, //
			{ 7, -14, 0, 1 } //
	};

	static int rows = 5;
	static int cols = 4;

	public static void main(String[] args) {
		// print(matrix);
		System.out.println(" >> ");
		// now just loop this out for all to get the max
		calculateMaxSumWithOrigin(0, 0);
	}

	private static void calculateMaxSumWithOrigin(int orX, int orY) {

		int maxSum = Integer.MIN_VALUE;
		int maxX = 0;
		int maxY = 0;
		int sumMatrix[][] = new int[rows][cols];

		for (int i = orX; i < rows; i++) {
			int rowSum = 0;
			for (int j = orY; j < cols; j++) {

				fill(i, j, sumMatrix, orX, orY, rowSum);
				if (maxSum < sumMatrix[i][j]) {
					maxSum = sumMatrix[i][j];
					maxX = i;
					maxY = j;
				}
				rowSum += matrix[i][j];
			}
		}

		print(sumMatrix);
		System.out.println(" MAX SUM " + maxSum);
		System.out.println(maxX + "," + maxY);
	}

	private static void print(int[][] mat) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(mat[i][j] + " , ");
			}
			System.out.println("");
		}
	}

	private static void fill(int i, int j, int[][] sumMatrix, int orX, int orY,
			int rowSum) {
		int val = matrix[i][j];
		int sumOfTopMatrix = i - 1 < orX ? 0 : sumMatrix[i - 1][j];
		sumMatrix[i][j] = val + sumOfTopMatrix + rowSum;
	}
}
