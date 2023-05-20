package week8.day7;

import java.io.*;

public class SWEA1244 {

	private static final int MAX_LENGTH = 6;
	private static int answer = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			String temp[] = br.readLine().split(" ");
			
			char[] prize = temp[0].toCharArray();
			int count = Integer.parseInt(temp[1]);
		
			DFS(prize, count, 0, 0);
			
			if(answer == -1) { //교환할 수 없는 상황이라면
				answer = Integer.parseInt(temp[0]);
			}
			
			sb.append("#" + test_case + " ").append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static void DFS(char[] prize, int count, int depth, int lastIndex) {
				
		if(depth == count) {
			String result = String.valueOf(prize);
			
			answer = Math.max(Integer.parseInt(result), answer);
			
			return;
		}
		
		if(lastIndex % (MAX_LENGTH - 1) == 0) {
			lastIndex = 0;
		}
		
		for(int i = lastIndex; i < prize.length - 1; i++) {
			for(int j = i + 1; j < prize.length; j++) {
				//i번째 수와 j번째 수를 swap
				char temp = prize[i];
				prize[i] = prize[j];
				prize[j] = temp;
				
				//dfs 호출
				DFS(prize, count, depth + 1, lastIndex + 1);
				
				//원복
				temp = prize[i];
				prize[i] = prize[j];
				prize[j] = temp;
			}
		}
		
		return;
	}

}
