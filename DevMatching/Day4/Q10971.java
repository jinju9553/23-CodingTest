package DevMatching.Day4;

import java.io.*;
import java.util.*;

public class Q10971 {

	private static boolean visited[];
	private static int weight[][];

	public static void main(String[] args) throws IOException { // 백준: 외판원 문제2
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
		
		Deque<Integer> deque = new LinkedList<>();
		
		double answer = Double.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			deque.add(i);
			
			double temp = DFS(deque, N, 0, 0, 0);
			
			answer = Math.min(answer, temp);
			deque.clear();
			visited = new boolean[N];
		}
		
		System.out.print(Math.round(answer));
	}
	
	private static double DFS(Deque<Integer> path, int N, int depth, int currentLength, int prevIdx) {
		
		if(N == depth) {
			int startIdx = path.peekFirst();
			return currentLength + weight[prevIdx][startIdx];
		}
		
		double answer = Integer.MAX_VALUE;
		
		for(int next = 0; next < N; next++) {
			int start = path.peekLast();
			if(!visited[next] && weight[start][next] != 0) {

				path.addLast(next);
				visited[next] = true;
				
				double temp = DFS(path, N, depth + 1, currentLength + weight[start][next], next);
				answer = Math.min(answer, temp);
				
				path.pollLast();
				visited[next] = false;
			}
		}
		
		return answer;
	}

}
