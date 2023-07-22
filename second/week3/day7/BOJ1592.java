package second.week3.day7;

import java.io.*;

public class BOJ1592 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int L = Integer.parseInt(input[2]);
		
		int[] bounces = new int[N + 1]; //0번은 사용하지 않음
		
		int idx = 1;
		int answer = 0;
		int maxBounce = 0;
		while(maxBounce < M) {
			//1.던진 횟수가 짝수
			if(bounces[idx] % 2 == 0) {
				idx = idx + L;
				if(idx > N) {
					idx = idx % N;
				}
			}
			else { //2.던진 횟수가 홀수
				idx = idx - L;
				if(idx <= 0) {
					idx += N;
				}
			}

			bounces[idx] += 1;
			maxBounce = Math.max(bounces[idx], maxBounce);
			
			answer++;
		}
		
		System.out.println(answer - 1);
	}

}
