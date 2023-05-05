package week2.day4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1149 { //14:32 시작 - 14:48 첫 테케 실행 - 14:51 정답

	private static int[][] cost;
	private static int[][] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		cost = new int[N][3];
		DP = new int[N][3];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0) {
					DP[i][j] = cost[i][j];
				}
			}
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == 0) { //빨강으로 칠한다면
					DP[i][j] = Math.min(DP[i - 1][j + 1], DP[i - 1][j + 2]) + cost[i][j];
				}
				if(j == 1) { //초록으로 칠한다면
					DP[i][j] = Math.min(DP[i - 1][j - 1], DP[i - 1][j + 1]) + cost[i][j];
				}
				if(j == 2) { //파랑으로 칠한다면
					DP[i][j] = Math.min(DP[i - 1][j - 2], DP[i - 1][j - 1]) + cost[i][j];
				}
			}
		}
		
		Arrays.sort(DP[N - 1]);
		
		System.out.print(DP[N - 1][0]);
	}

}
