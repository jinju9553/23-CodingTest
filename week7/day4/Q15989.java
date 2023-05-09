package week7.day4;

import java.io.*;

public class Q15989 {
	
	private static int N = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] DP;
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			int num = Integer.parseInt(br.readLine());
			
			DP = new int[num + 1][N + 1];
			
			DP[0][0] = 1;
			DP[1][0] = DP[1][1] = 1;
			
			if(num > 1) {
				DP[2][1] = 1;
				DP[2][2] = 1;
				DP[2][3] = 0;
				
				DP[2][0] = DP[2][1] + DP[2][2] + DP[2][3];
			}
			
			if(num > 2) {
				for(int i = 3; i <= num; i++) {
					DP[i][1] = 1;
					DP[i][2] = DP[i - 2][1] + DP[i - 2][2];
					DP[i][3] = DP[i - 3][0];
					
					DP[i][0] = DP[i][1] + DP[i][2] + DP[i][3];
				}
			}
			
			sb.append(DP[num][0]).append('\n');
		}
		
		System.out.print(sb.toString());
	}
}
