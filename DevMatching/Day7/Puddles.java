package DevMatching.Day7;

public class Puddles {

	private static final int DIV = 1_000_000_007;
	private static int[][] DP;

	public static void main(String[] args) {

		int m = 4; // 가로(col)
		int n = 3; // 세로(row)
		int[][] puddles = { { 2, 2 } };

		int answer = 0;

		int[][] map = new int[n + 1][m + 1];
		DP = new int[n + 1][m + 1];

		for (int i = 0; i < puddles.length; i++) {
			int c = puddles[i][0]; //반대로 주어짐
			int r = puddles[i][1];

			map[r][c] = -1;
		}

		DP[1][1] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == 1 && j == 1) {
					continue;
				}

				if (map[i][j] == -1) {
					continue;
				}

				if (i - 1 > 0 && map[i - 1][j] != -1) {
					DP[i][j] += DP[i - 1][j] % DIV;
				}

				if (j - 1 > 0 && map[i][j - 1] != -1) {
					DP[i][j] += DP[i][j - 1] % DIV;
				}
			}
		}

		answer = (DP[n][m] % DIV);

		System.out.print(answer);
	}
}
