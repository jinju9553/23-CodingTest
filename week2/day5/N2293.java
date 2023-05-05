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
		for (int i = 0; i < N; i++) { //��� coin ����� ��ȸ�ϸ鼭
			for (int j = 1; j <= K; j++) { //� �ݾ� k�� ���ؼ�
				if (j >= coins[i]) //���� �� coin���� k���� ���� �� �ִ°�?
					DP[j] += DP[j - coins[i]]; 
				//��: 2��¥���� ������ 6���� ����� �ʹٸ�? 4���� ����� ��� ����� �����ٰ� 2��¥�� �ϳ��� �ٿ��ָ� �ȴ�.
				//���� DP[6] = DP[6] + DP[4] (���ݱ����� ���� + 4���� ����� ��� ����� ��)
			}
		}

		System.out.print(DP[K]);
	}

}
