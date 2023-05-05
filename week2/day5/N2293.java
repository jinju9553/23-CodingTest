package week2.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2293 {

	private static int[] coins;
	private static int[] DP;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int K = Integer.parseInt(temp[1]);

		coins = new int[N];
		DP = new int[K + 1];

		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		DP[0] = 1;
		for (int i = 0; i < N; i++) { //모든 coin 목록을 순회하면서
			for (int j = 1; j <= K; j++) { //어떤 금액 k에 대해서
				if (j >= coins[i]) //지금 고른 coin으로 k원을 만들 수 있는가?
					DP[j] += DP[j - coins[i]]; 
				//예: 2원짜리를 가지고 6원을 만들고 싶다면? 4원을 만드는 모든 경우의 수에다가 2원짜리 하나만 붙여주면 된다.
				//따라서 DP[6] = DP[6] + DP[4] (지금까지의 누계 + 4원을 만드는 모든 경우의 수)
			}
		}

		System.out.print(DP[K]);
	}

}
