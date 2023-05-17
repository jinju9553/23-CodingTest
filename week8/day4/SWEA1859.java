package week8.day4;

import java.util.*;

public class SWEA1859 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			int[] cost = new int[N];
			for(int i = 0; i < N; i++) { //배열에 값 할당 
				cost[i] = sc.nextInt();
			}
			
			int max = cost[N - 1];
			long result = 0;
			for(int i = N - 2; i >= 0; i--) {
				if(cost[i] < max) { //최대 금액보다 i일의 시세(cost[i])가 낮다면
					result += (max - cost[i]); //i일의 마진을 누적시킨다.
				}
				else { //최대 금액이 발견되었다면 갱신
					max = cost[i];
				}
			}
			
			sb.append("#" + test_case + " ").append(result).append('\n');
		}
		
		System.out.print(sb);
	}

}
