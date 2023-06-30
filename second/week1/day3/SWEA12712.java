package second.week1.day3;

import java.io.*;

public class SWEA12712 { //수정 필요

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] temp = br.readLine().split(" ");

			int N = Integer.parseInt(temp[0]);
			int M = Integer.parseInt(temp[1]);

			int[][] matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(input[j]);
				}
			}

			int plusResult = 0;
			int crossResult = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int result1 = calculatePlusShape(matrix, M, r, c);
					int result2 = calculateCrossShape(matrix, M, r, c);

					plusResult = Math.max(result1, plusResult);
					crossResult = Math.max(result2, plusResult);
				}
			}

			int answer = Math.max(plusResult, crossResult);

			sb.append("#" + test_case + " ").append(answer).append("\n");
		}

		System.out.print(sb);
	}

	public static int calculatePlusShape(int[][] matrix, int M, int midRow, int midCol) {
		int N = matrix.length;

		int startRow = calculateStart(midRow, M);
		int startCol = calculateStart(midCol, M);

		int endRow = calculateEnd(midRow, N, M);
		int endCol = calculateEnd(midCol, N, M);

		int sum = 0;
		for (int i = startRow; i <= endRow; i++) {
			for (int j = startCol; j <= endCol; j++) {
				if (i == midRow || j == midCol) {
					sum += matrix[i][j];
				}
			}
		}

		return sum;
	}

	public static int calculateCrossShape(int[][] matrix, int M, int midRow, int midCol) {
		int N = matrix.length;

		int startRow = calculateStart(midRow, M);
		int startCol = calculateStart(midCol, M);

		int endRow = calculateEnd(midRow, N, M);
		int endCol = calculateEnd(midCol, N, M);

		int sum = 0;
		for (int i = startRow; i <= endRow; i++) {
			for (int j = startCol; j <= endCol; j++) {
				if (i == j) {
					sum += matrix[i][j];
				}
			}
		}

		return sum;
	}

	public static int calculateStart(int mid, int M) {
		int result = 0;

		if (mid - M >= -1) {
			result = mid - M + 1;
		}

		return result;
	}

	public static int calculateEnd(int mid, int N, int M) {
		int result = 0;

		if (mid + M <= N) {
			result = mid + M - 1;
		}

		return result;
	}

}
