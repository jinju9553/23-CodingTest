package SWM.Day14;

import java.io.*;

public class N2293 { //14:52 ���� - 15:03 �н� // 15:29 �簳 - 16:32 �� Ǯ�� �׽�Ʈ ����(��ƴ�)

	private static int maxCoin;
	
	private static int[] coins;
	private static int[][] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int K = Integer.parseInt(temp[1]);
		
		coins = new int[N];
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, coins[i]);
		}
		
		maxCoin = max;
		DP = new int[maxCoin + 1][N + 1]; //[�ݾ�(0���� �Ұ���)][����� ���� ��(�ε��� 0 ����)]
		//�־��� ������ ��ġ�� ���Ϸ��� �ݾ׺��� Ŭ ���� ���� 
		
		for(int i = 0; i < K; i++) { //���� �ε��� ������
			for(int j = 1; j <= N; j++) {
				if(j == 1) { //������ �� ������ ���ٸ�
					DP[i][j] = calculateCount(i);
				}
				else { //������ j���� ������ ���ٸ�
					DP[i][j] = calculateMultiple(j);
				}
			}
		}
		
		System.out.print("");
	}

	public static int calculateCount(int n) {
		int count = 0;
		
		for(int i = 0; i < coins.length; i++) {
			if(n % coins[i] == 0) {
				count += 1;
			}
		}
		
		return count;
	}
	
	public static int calculateMultiple(int k) {
		int sum = 0;
		
		//����: k�� �̴� ����, i�� j�� �ε���
		for(int i = 1; i < maxCoin; i++) {
			int mul = 1;
			for(int j = i; j < k; j++) { //k���� ���� ��Ÿ���� => k�� �ݺ�
				int idx = coins[j];
				mul *= DP[idx][1]; //TODO: �ε��� ���� �ʰ��� ����
				//TODO: DP[5][1] * DP[2][1]�� ���� �� �ְ����� DP[5][1] * DP[1][1]�� ���� �� ����...
			}
			//k���� ���� �������� �հ迡 �����ش�
			sum += (mul - (k - 1));
		}
		
		return sum;
	}
}
