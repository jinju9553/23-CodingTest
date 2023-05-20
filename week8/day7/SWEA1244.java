package week8.day7;

import java.io.*;

public class SWEA1244 {

	private static int answer = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			String temp[] = br.readLine().split(" ");
			
			char[] prize = temp[0].toCharArray();
			int count = Integer.parseInt(temp[1]);
		
			answer = -1;
			DFS(prize, count, 0, 0);
			
			sb.append("#" + test_case + " ").append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static void DFS(char[] prize, int count, int depth, int lastIndex) {
		
		if(depth == count) {
			String result = String.valueOf(prize); //�ּҰ� ������ �ʴ��� �����ϱ�
			
			answer = Math.max(Integer.parseInt(result), answer);
			
			return;
		}
		
		for(int i = lastIndex; i < prize.length; i++) {
			for(int j = i + 1; j < prize.length; j++) {
				//i��° ���� j��° ���� swap
				char temp = prize[i];
				prize[i] = prize[j];
				prize[j] = temp;
				
				//dfs ȣ��
				DFS(prize, count, depth + 1, lastIndex + 1);
				
				//����
				temp = prize[i];
				prize[i] = prize[j];
				prize[j] = temp;
			}
		}
		
		return;
	}

}
