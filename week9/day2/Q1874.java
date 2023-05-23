package week9.day2;

import java.io.*;
import java.util.*;

public class Q1874 {

	private static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] targets = new int[N];
		
		for(int i = 0; i < N; i++) {
			targets[i] = Integer.parseInt(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		
		boolean isValid = true;
		
		int i = 0;
		int j = 1;
		while(i < targets.length || j <= N) {
			int target = targets[i];
			
			//�ݺ����� ���۵��ڸ��� push�� �ϱ� ������ isEmpty()�� ������� �ʾƵ� ��.
			if(target >= j) {
				while(j <= target) {
					stack.push(j);
					sb.append("+").append('\n');
					j++;
				}
			}
			else if(Objects.equals(stack.peek(), target)) {
				stack.pop();
				sb.append("-").append('\n');
				i++;
			}
			else {
				isValid = false;
				break;
			}
		}
		
		if(isValid) {
			System.out.print(sb);
		}
		else {
			System.out.print("NO");
		}
	}


}
