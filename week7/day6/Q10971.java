package week7.day6;

import java.util.*;
import java.io.*;

public class Q10971 {

	private static boolean[] visited;
	private static int[][] weight;
	private static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		visited = new boolean[N];
		weight = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				weight[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			visited[i] = true; //여기서 시작하기 때문에 depth = 1로 초기화 
			
			DFS(i, i, N, 1, 0);

			visited = new boolean[N];
		}
		
		System.out.print(answer);
	}
	
	public static void DFS(int start, int curr, int N, int depth, int length) {
		
		if(N == depth) {
			if(weight[curr][start] != 0) {
				answer = Math.min(length + weight[curr][start], answer);
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && weight[curr][i] != 0) {
				visited[i] = true;
				
				DFS(start, i, N, depth + 1, length + weight[curr][i]);
				
				visited[i] = false;
			}
		}
		
		return;
	}

}
