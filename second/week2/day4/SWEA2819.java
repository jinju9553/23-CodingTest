package second.week2.day4;

import java.io.*;
import java.util.*;

public class SWEA2819 {

	private static final int N = 4;
	private static final int SIZE = 7;

	private static int[] dx = { 1, 0, -1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	private static String[][] matrix;

	private static Set<String> set;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			set = new HashSet<>();
			matrix = new String[N][N];

			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					matrix[i][j] = line[j];
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					//함수에 진입하자마자 nx, ny를 구하므로 matrix[i][j] 값은 미리 합해주어야 함 (깊이 1에서 시작)
					DFS(1, "" + matrix[i][j], i, j);
				}
			}

			int result = set.size();

			sb.append("#" + test_case + " ").append(result).append("\n");
		}

		System.out.print(sb);
	}

	public static void DFS(int depth, String curr, int row, int col) {
		if (SIZE == depth) {
			set.add(curr);

			return;
		}

		int nx = 0;
		int ny = 0;
		for (int k = 0; k < dx.length; k++) {
			nx = col + dx[k];
			ny = row + dy[k];

			if (!isValidIndex(nx, ny)) {
				continue;
			}

			DFS(depth + 1, curr + matrix[ny][nx], ny, nx);
		}

		return;
	}

	public static boolean isValidIndex(int nx, int ny) {
		return (nx > -1 && ny > -1 && nx < N && ny < N);
	}
}
