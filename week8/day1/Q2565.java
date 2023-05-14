package week8.day1;

import java.io.*;
import java.util.*;

public class Q2565 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		LinkedList<int[]> poles = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			
			int A = Integer.parseInt(temp[0]);
			int B = Integer.parseInt(temp[1]);
			
			int[] result = {A, B};
			poles.add(result);
		}
		
		Collections.sort(poles, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		
		int max = Integer.MIN_VALUE;
		int[] DP = new int[N];
		Arrays.fill(DP, 1);
		
		for(int i = 1; i < N; i++) {
			int[] now = poles.get(i);
			
			for(int j = 0; j < i; j++) {
				int[] prev = poles.get(j);
				if(prev[0] < now[0] && prev[1] < now[1]) {
					DP[i] = Math.max(DP[j] + 1, DP[i]);
				}
			}
			max = Math.max(DP[i], max);
		}
		
		System.out.print(N - max);
	}

}
