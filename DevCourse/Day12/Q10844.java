package DevCourse.Day12;

import java.io.*;

public class Q10844 {
	
	private static final int SIZE = 10;
	private static final int MOD = 1_000_000_000; 
	private static long[][] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		DP = new long [N + 1][SIZE];
		
		DP[1][0] = 0;
		for(int i = 1; i < SIZE; i++) {
			DP[1][i] = 1;
		}
		
		//나머지 구하기
		for(int i = 2; i < N + 1; i++) {
			for(int j = 1; j < SIZE - 1; j++) {
				DP[i][j] = ((DP[i - 1][j - 1] % MOD) + (DP[i - 1][j + 1] % MOD)) % MOD;
			}
			DP[i][0] = DP[i - 1][1] % MOD;
			DP[i][9] = DP[i - 1][8] % MOD;
		}
		
		//출력
		long sum = 0;
		for(int i = 0; i < SIZE; i++) {
			sum = (sum + (DP[N][i] % MOD)) % MOD;
		}
		
		System.out.print(sum);
	}

}
