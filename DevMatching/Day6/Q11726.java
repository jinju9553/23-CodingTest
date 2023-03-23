package DevMatching.Day6;

import java.io.*;

public class Q11726 {

	private static final int DIV = 10_007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] DP = new long[N + 1];
		
		DP[1] = 1; //(2x1) ũ�⸦ ���� ����� ��
		if(N > 1) {
			DP[2] = DP[1] + 1; //(2x2) ũ�⸦ ���� ����� ��
		}
		
		for(int i = 3; i <= N; i++) {
			DP[i] = ((DP[i - 1] % DIV) + (DP[i - 2] % DIV)) % DIV;
		}
		
		long answer = DP[N];
		
		System.out.print(answer);
	}

}
