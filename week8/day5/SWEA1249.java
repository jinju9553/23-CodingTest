package week8.day5;

import java.io.*;
import java.util.*;

public class SWEA1249 {
	
	private static int N;
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	private static int[][] matrix;
	private static int[][] DP;
	private static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			matrix = new int[N][N];
			DP = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				char[] lines = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					matrix[i][j] = lines[j] - '0';
					DP[i][j] = Integer.MAX_VALUE;
				}
			}
			
			BFS(0, 0);
			
			sb.append("#" + test_case + " ").append(DP[N - 1][N - 1]).append('\n');
		}

		System.out.print(sb);
	}
	
	public static void BFS(int startR, int startC) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(startR, startC));
		DP[startR][startC] = 0;
		visited[startR][startC] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			int nr = 0;
			int nc = 0;
			for(int i = 0; i < dx.length; i++) {
				nr = n.row + dy[i];
				nc = n.col + dx[i];
				
				if(isValid(nr, nc)) {
					//이미 방문한 적 있더라도 더 작은 DP값이 발견되면 다시 방문
					if(!visited[nr][nc] || DP[n.row][n.col] + matrix[nr][nc] < DP[nr][nc]) {
						DP[nr][nc] = DP[n.row][n.col] + matrix[nr][nc];
						visited[nr][nc] = true;
						queue.add(new Node(nr, nc));	
					}
				}
			}
		}
		
		return;
	}
	
	public static boolean isValid(int row, int col) {
		return (row >= 0 && col >= 0 && row < N && col < N);
	}

}

class Node{
	int row;
	int col;
	
	public Node(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
