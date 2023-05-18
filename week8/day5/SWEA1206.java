package week8.day5;

import java.util.*;
import java.io.*;

public class SWEA1206 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] height = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = 0;
			for(int i = 2; i < N - 2; i++) {
				int secondHeight = -1;
				
				for(int j = -2; j <= 2; j++) {
					if(j == 0) {
						continue;
					}
					
					if(height[i + j] > height[i]) {
						secondHeight = -1;
						break;
					}
					
					secondHeight = Math.max(height[i + j], secondHeight);
				}
				
				if(secondHeight > -1) {
					result += (height[i] - secondHeight);
				}
			}
			
			sb.append("#" + test_case + " ").append(result).append('\n');
		}
        
        System.out.print(sb);
	}

}
