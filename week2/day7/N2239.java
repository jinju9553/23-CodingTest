package week2.day7;

import java.io.*;

public class N2239 {

	private static final int SIZE = 9;
	private static int[][] matrix = new int[SIZE][SIZE];
	private static boolean isFinished = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < SIZE; i++) {
			String line = br.readLine();
			for (int j = 0; j < SIZE; j++) {
				matrix[i][j] = line.charAt(j) - '0';
			}
		}

		backTracking(0);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				sb.append(matrix[i][j]);
			}
			sb.append('\n');
		}

		System.out.print(sb);
	}

	public static void backTracking(int k) {
		if (k == SIZE * SIZE) {
			isFinished = true;
			return;
		}

		int row = k / SIZE;
		int col = k % SIZE;

		if (matrix[row][col] != 0) {
			backTracking(k + 1);
		} 
		else if (matrix[row][col] == 0) {
			
			for (int i = 1; i <= SIZE; i++) { // item 결정
				if (checkRow(row, i) && checkCol(col, i) && checkMat(row, col, i)) {
					matrix[row][col] = i;
					backTracking(k + 1);
				}

				if (isFinished) {
					return;
				}

				matrix[row][col] = 0; // 원복 필요
			}
		}

		return;
	}

	public static boolean checkRow(int row, int key) {
		for (int i = 0; i < SIZE; i++) {
			if (matrix[row][i] == key) {
				return false;
			}
		}

		return true;
	}

	public static boolean checkCol(int col, int key) {
		for (int i = 0; i < SIZE; i++) {
			if (matrix[i][col] == key) {
				return false;
			}
		}

		return true;
	}

	public static boolean checkMat(int row, int col, int key) {
		int startRow = row / 3;
		int startCol = col / 3;

		int matRow = startRow * 3;
		int matCol = startCol * 3;

		for (int i = matRow; i < matRow + 3; i++) {
			for (int j = matCol; j < matCol + 3; j++) {
				if (matrix[i][j] == key) {
					return false;
				}
			}
		}

		return true;
	}
}
