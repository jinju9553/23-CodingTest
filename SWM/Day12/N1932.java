package SWM.Day12;

import java.io.*;
import java.util.StringTokenizer;

public class N1932 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] DP = new long[N][N];
		long[][] triangle = new long[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				DP[i][j] = -1;
				triangle[i][j] = -1;
			}
		}
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < (i + 1); j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		long max = triangle[0][0];
		
		DP[0][0] = triangle[0][0];
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < N; j++) {
				long a = -1; 
				if(i - 1 >= 0 && triangle[i - 1][j] != -1) {
					a = triangle[i][j] + DP[i - 1][j]; //왼쪽 위
				}
				
				long b = -1; 
				if(i - 1 >= 0 && j - 1 >= 0 && triangle[i - 1][j - 1] != -1) {
					b = triangle[i][j] + DP[i - 1][j - 1]; //오른쪽 위
				}
				
				DP[i][j] = Math.max(a, b);
				max = Math.max(max, DP[i][j]);
			}
		}
		
		System.out.print(max);
	}

}
