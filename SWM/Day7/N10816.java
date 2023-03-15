package SWM.Day7;

import java.io.*;
import java.util.Arrays;

public class N10816 {
	
	private static int[] cards;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		
		cards = new int[N];
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(cards);
		
		int M = Integer.parseInt(br.readLine());
		temp = br.readLine().split(" ");
		
		int[] keys = new int[M];
		for(int i = 0; i < M; i++) {
			keys[i] = Integer.parseInt(temp[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			int lowerResult = lowerBound(keys[i], 0, N - 1);
			int upperResult = upperBound(keys[i], 0, N - 1);
			
			int result = 0;
			if(lowerResult != -1 && upperResult != -1) {
				result  = (upperResult - lowerResult) + 1;
			}
			sb.append(result).append(' ');
		}
		
		System.out.print(sb);
	}

	public static int lowerBound(int key, int start, int end) {		
		int middle = 0;
		int answer = -1;
		
		while(start <= end) {
			middle = (start + end) / 2;

			if(key == cards[middle]) {
				answer = middle;
				end = middle - 1;
			}
			else if(key < cards[middle]) {
				end = middle - 1;
			}
			else if(key > cards[middle]) {
				start = middle + 1; 
			}
		}
		
		return answer;
	}
	
	public static int upperBound(int key, int start, int end) {
		int middle = 0;
		int answer = -1;
		
		while(start <= end) {
			middle = (start + end) / 2;

			if(key == cards[middle]) {
				answer = middle;
				start = middle + 1;
			}
			else if(key < cards[middle]) {
				end = middle - 1;
			}
			else if(key > cards[middle]) {
				start = middle + 1; 
			}
		}
		
		return answer;
	}
}
