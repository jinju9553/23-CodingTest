package second.week1.day4;

import java.io.*;

public class SWEA1961 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());

			int[][] matrix = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(temp[j]);
				}
			}

			int[][] rotated1 = rotateMatrix(matrix, N);
			int[][] rotated2 = rotateMatrix(rotated1, N);
			int[][] rotated3 = rotateMatrix(rotated2, N);

			sb.append("#" + test_case + "\n");
			for (int i = 0; i < N; i++) {
				String row = appendOneRow(rotated1, N, i);
				sb.append(row + " ");

				row = appendOneRow(rotated2, N, i);
				sb.append(row + " ");

				row = appendOneRow(rotated3, N, i);
				sb.append(row + "\n");
			}
		}

		System.out.print(sb);
	}

	public static int[][] rotateMatrix(int[][] matrix, int N) {
		int[][] result = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = matrix[N - j - 1][i]; //반대로 쓰지 않게 주의
			}
		}

		return result;
	}

	public static String appendOneRow(int[][] matrix, int N, int row) {
		StringBuilder sb = new StringBuilder();

		for (int j = 0; j < N; j++) {
			sb.append(matrix[row][j]);
		}

		return sb.toString();
	}

}
