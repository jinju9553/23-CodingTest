package week7.day6;

import java.io.*;
import java.util.Arrays;

public class Q12865 {
	
	private static int[] DP;
	private static int[] weights;
	private static int[] values;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = (br.readLine()).split(" ");
		
		int N = Integer.parseInt(temp[0]);
		int K = Integer.parseInt(temp[1]);
		
		DP = new int[K + 1]; //0부터 K까지
		weights = new int[N];
		values = new int[N];
		
		for(int i = 0; i < N; i++) {
			temp = (br.readLine()).split(" ");
			
			int W = Integer.parseInt(temp[0]);
			int V = Integer.parseInt(temp[1]);
			
			weights[i] = W;
			values[i] = V;
			
			DP[W] = Math.max(DP[W], V);
		}
		
		for(int i = 0; i < N; i++) {
			int w = weights[i];
			for(int j = i + 1; j < N; j++) {
				int n = weights[j];
				
				if(w - n <= 0) {
					continue;
				}
				
				DP[w] = Math.max(DP[n] + DP[w - n], DP[w]);
			}
		}
		
		Arrays.sort(DP);
		
		System.out.print(DP[K]);
	}

}
