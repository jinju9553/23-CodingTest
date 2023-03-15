package SWM.Day11;

import java.io.*;

public class N9461 {
	
	private static long DP[];
	private static final int MAX_SIZE = 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		DP = new long[MAX_SIZE + 1];
		initDP();
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			int target = Integer.parseInt(br.readLine());
			
			sb.append(DP[target]).append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static void initDP() {
		DP[1] = 1;
		DP[2] = DP[1];
		DP[3] = DP[2];
		DP[4] = DP[3] + DP[1];
		DP[5] = DP[4];
		
		for(int i = 6; i <= 8; i++) {
			DP[i] = DP[i - 1] + DP[8 - i + 1];
		}
		
		for(int i = 9; i <= MAX_SIZE; i++) {
			DP[i] = DP[i - 1] + DP[i - 5];
		}
	}

}
