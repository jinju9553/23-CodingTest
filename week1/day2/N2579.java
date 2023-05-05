package week1.day2;

import java.io.*;

public class N2579 {
	
	public static int[] scores;
	public static int[] DP;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		scores = new int[num + 1]; //0은 사용하지 않음
		DP = new int[num + 1];
		
		for(int i = 1; i <= num; i++) {
			scores[i] = Integer.parseInt(br.readLine());
			DP[i] = 0;
		}
		
		DP[1] = scores[1];
		if(num >= 2) { //입력값 예외처리 주의
			DP[2] = scores[1] + scores[2];
		}

		for(int n = 3; n <= num; n++) {
			DP[n] = Math.max(scores[n - 1] + DP[n - 3], DP[n - 2]) + scores[n];
		}
		
		System.out.print(DP[num]);
	}
}
