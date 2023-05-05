package week4.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AsymTiling {

	//private static final int MOD = 10_007;
	private static final int MOD = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //사각형의 너비
		
		long[] DP = new long[N + 1];
		
		DP[1] = 1; //(2x1) 크기를 덮는 방법의 수
		if(N > 1) {
			DP[2] = DP[1] + 1; //(2x2) 크기를 덮는 방법의 수
		}
		
		//1.전체 경우의 수
		for(int i = 3; i <= N; i++) {
			DP[i] = ((DP[i - 1] % MOD) + (DP[i - 2] % MOD)) % MOD;
		}
		
		long answer1 = DP[N];
		
		//2.대칭인 경우의 수
		long answer2 = 0;
		if(N % 2 == 0) { //N이 짝수라면
			answer2 = ((DP[(N - 2) / 2] % MOD) + (DP[N / 2] % MOD)) % MOD;
		}
		else { //N이 홀수라면
			answer2 = DP[(N - 1) / 2];
		}
		
		long k = ((answer1 - answer2) + MOD) % MOD;
		if(N == 1 || N == 2) {
			k = 0;
		}
		
		System.out.print(k);
	}

}
