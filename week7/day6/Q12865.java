package week7.day6;

import java.io.*;

public class Q12865 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = (br.readLine()).split(" ");
		
		int N = Integer.parseInt(temp[0]);
		int K = Integer.parseInt(temp[1]);
		
		int[] DP = new int[K + 1]; //0부터 K까지
		int[] weights = new int[N + 1]; //1부터 N번까지
		int[] values = new int[N + 1]; //1부터 N번까지
		
		for(int i = 1; i <= N; i++) {
			temp = (br.readLine()).split(" ");

			weights[i] = Integer.parseInt(temp[0]);
			values[i] = Integer.parseInt(temp[1]);
		}
		
		for(int i = 1; i <= N; i++) { //전체 N가지 물건을 탐색한다.
			int w = weights[i];
			int v = values[i];
			for(int j = K; j >= w; j--) {
				//수용 가능한 무게(K)부터 현재 탐색하는 물건의 무게(j)까지
				//for문 조건에서부터 i번째 물건을 가방에 넣을 수 있는지 확인한다.
				DP[j] = Math.max(DP[j - w] + v, DP[j]);
			}
		}
		
		System.out.print(DP[K]);
	}

}
