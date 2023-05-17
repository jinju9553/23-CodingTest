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
			for(int i = 0; i < N; i++) { //�迭�� �� �Ҵ� 
				cost[i] = sc.nextInt();
			}
			
			int count = 0;
			int result = 0;
			for(int i = 0; i < N - 1; i++) {
				if(cost[i + 1] >= cost[i]) {
					result -= cost[i];
					count += 1;
				}
				else { //������ cost(cost[i + 1])�� ����(cost[i])���� �۴ٸ�
					result += count * cost[i];
					count = 0;
				}
			}
			result += count * cost[N - 1];
			
			sb.append("#" + test_case + " ").append(result).append('\n');
		}
		
		System.out.print(sb);
	}

}
