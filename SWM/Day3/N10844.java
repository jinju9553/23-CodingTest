package SWM.Day3;

import java.io.*;

public class N10844 {
	
	private static int[] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		DP = new int[num + 1];
		
		DP[1] = 9;
		for(int n = 2; n <= num; n++) {
			DP[n] = (DP[n - 1] - 1) * 2 + 1;
		}
		
		int answer = DP[num] % 1_000_000_000; //int는 2^32까지 표현가능
		
		System.out.println(answer);
	}
}
