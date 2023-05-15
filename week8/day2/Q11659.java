package week8.day2;

import java.io.*;
import java.util.*;

public class Q11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");

		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		
		int[] numbers = new int[N + 1]; //1부터 N까지
		int[] sum = new int [N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + numbers[i];
		}
		
		StringBuilder sb = new StringBuilder();
		while(M-- > 0) {
			temp = br.readLine().split(" ");
			
			int start = Integer.parseInt(temp[0]);
			int end = Integer.parseInt(temp[1]);
			
			int sumOfSections = sum[end] - sum[start - 1];
			
			sb.append(sumOfSections).append('\n');
		}
		
		System.out.print(sb);
	}

}
