package week4.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AsymTiling {

	//private static final int MOD = 10_007;
	private static final int MOD = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //�簢���� �ʺ�
		
		long[] DP = new long[N + 1];
		
		DP[1] = 1; //(2x1) ũ�⸦ ���� ����� ��
		if(N > 1) {
			DP[2] = DP[1] + 1; //(2x2) ũ�⸦ ���� ����� ��
		}
		
		//1.��ü ����� ��
		for(int i = 3; i <= N; i++) {
			DP[i] = ((DP[i - 1] % MOD) + (DP[i - 2] % MOD)) % MOD;
		}
		
		long answer1 = DP[N];
		
		//2.��Ī�� ����� ��
		long answer2 = 0;
		if(N % 2 == 0) { //N�� ¦�����
			answer2 = ((DP[(N - 2) / 2] % MOD) + (DP[N / 2] % MOD)) % MOD;
		}
		else { //N�� Ȧ�����
			answer2 = DP[(N - 1) / 2];
		}
		
		long k = ((answer1 - answer2) + MOD) % MOD;
		if(N == 1 || N == 2) {
			k = 0;
		}
		
		System.out.print(k);
	}

}
