package week8.day1;

import java.io.*;

public class Q1904 {
	
	private static final int DIV = 15746; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] DP = new int[N + 1]; //1부터 N까지 사용
		
		DP[1] = 1;
		
		if(N >= 2) {
			DP[2] = 2;
		}
		
		for(int i = 3; i <= N; i++) {
			int temp = (DP[i - 1] % DIV) + (DP[i - 2] % DIV);
			DP[i] = (temp % DIV);
		}
		
		System.out.print(DP[N]);
	}

}
