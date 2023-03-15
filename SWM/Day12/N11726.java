package SWM.Day12;

import java.io.*;

public class N11726 {

	private static int answer = 0;
	
	private static int[] items = {1, 2};
	private static int[] bucket;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N % 2 != 0) {
			for(int i = N / 2 + 1; i <= N; i++) {
				bucket = new int[i];
				solution(i, N, 0);
			}
		}
		else {
			for(int i = N / 2; i <= N; i++) {
				bucket = new int[i];
				solution(i, N, 0);
			}
		}
		
		System.out.print(answer % 10_007);
	}
	
	public static void solution(int N, int target,  int k) {
		
		if(k == N) {
			int sum = 0;
			for(int n : bucket) {
				sum += n;
			}
			
			if(sum == target) {
				answer++;
			}
			
			return;
		}
		
		for(int i = 0; i < items.length; i++) { //중복순열
			bucket[k] = items[i];
			solution(N, target, k + 1);
		}
		
		return;
	}

}
