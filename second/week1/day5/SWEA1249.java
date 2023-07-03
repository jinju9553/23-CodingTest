package second.week1.day5;

import java.io.*;
import java.util.*;
import java.awt.Point;

public class SWEA1249 {

	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	private static int[][] matrix;
	private static int[][] DP;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			matrix = new int[N][N];
			DP = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				String lines = br.readLine();
				for(int j = 0; j < N; j++) {
					matrix[i][j] = lines.charAt(j) - '0';
					DP[i][j] = Integer.MAX_VALUE;
				}
			}
			
			BFS(0, 0);
			
			sb.append("#" + test_case + " ").append(DP[N - 1][N - 1]).append("\n");
		}
		
		System.out.print(sb);
	}
	
	private static void BFS(int startX, int startY) {
		Queue<Point> queue = new LinkedList<>();
		
		visited[startY][startX] = true;
		DP[startY][startX] = 0;
		queue.add(new Point(startX, startY));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(isEndOfMatrix(p.x, p.y)) {
				return;
			}
			
			int nx = 0;
			int ny = 0;
			for(int i = 0; i < dx.length; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				
				if(!isValidIndex(nx, ny)) {
					continue;
				}
				
				if(DP[ny][nx] > DP[p.y][p.x] + matrix[ny][nx]) {
					DP[ny][nx] = DP[p.y][p.x] + matrix[ny][nx];
					queue.add(new Point(nx, ny)); //À¯¸ÁÇÑ °æ·Î¸¸ Å½»öÇÑ´Ù.
				}
			}
		}
		
		return;
	}

	private static boolean isValidIndex(int nx, int ny) {
		return (nx > -1 && ny > -1 && nx < matrix.length && ny < matrix.length);
	}
	
	private static boolean isEndOfMatrix(int px, int py) {
		return (px == matrix.length - 1 && py == matrix.length);
	}
}
