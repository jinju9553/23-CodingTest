package week8.day5;

import java.io.*;
import java.util.*;

public class SWEA1208 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 1;
		int N = 100;
		
		int[] boxes = new int[N];

		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			int dump = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				boxes[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(boxes);
			
			int lowerBound = 0;
			int upperBound = N - 1;
			for(int i = 0; i < dump; i++) {
				//1.dump 작업을 수행한다.
				boxes[lowerBound] += 1;
				boxes[upperBound] -= 1;
				
				//2.다음 lowerBound를 찾는다.
				for(int j = 0; j < N - 1; j++) {
					if(boxes[j] < boxes[j + 1]) {
						lowerBound = j;
						break;
					}
				}
				
				//3.다음 upperBound를 찾는다.
				if(boxes[upperBound] < boxes[upperBound - 1]) {
					upperBound = upperBound - 1;
				}
				else { // upperBound >= upperBound - 1
					upperBound = N - 1;
				}
			}
			
			Arrays.sort(boxes);
			
			int result = boxes[N - 1] - boxes[0];
			sb.append("#" + test_case + " ").append(result).append('\n');
		}
        
        System.out.print(sb);
	}
}
