package second.week4.day1;

import java.io.*;
import java.util.*;

public class BOJ2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] cards = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				for(int k = j + 1; k < N; k++) {
					if(cards[i] + cards[j] + cards[k] > M) {
						continue;
					}
					sum = Math.max(sum, cards[i] + cards[j] + cards[k]);
				}
			}
		}
		
		System.out.println(sum);
	}

}
