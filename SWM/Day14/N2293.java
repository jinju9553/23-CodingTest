package SWM.Day14;

import java.io.*;

public class N2293 { //14:52 시작 - 15:03 패스 // 15:29 재개 - 16:32 못 풀고 테스트 종료(어렵다)

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
		DP = new int[maxCoin + 1][N + 1]; //[금액(0원은 불가능)][사용한 동전 수(인덱스 0 제외)]
		//주어진 동전의 가치가 구하려는 금액보다 클 수도 있음 
		
		for(int i = 0; i < K; i++) { //여기 인덱스 점검좀
			for(int j = 1; j <= N; j++) {
				if(j == 1) { //동전을 한 종류만 쓴다면
					DP[i][j] = calculateCount(i);
				}
				else { //동전을 j개의 종류만 쓴다면
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
		
		//주의: k는 뽑는 개수, i와 j는 인덱스
		for(int i = 1; i < maxCoin; i++) {
			int mul = 1;
			for(int j = i; j < k; j++) { //k개의 곱을 나타낸다 => k번 반복
				int idx = coins[j];
				mul *= DP[idx][1]; //TODO: 인덱스 범위 초과에 주의
				//TODO: DP[5][1] * DP[2][1]은 구할 수 있겠지만 DP[5][1] * DP[1][1]은 어케 할 건지...
			}
			//k개의 곱을 구했으면 합계에 더해준다
			sum += (mul - (k - 1));
		}
		
		return sum;
	}
}
