package week2.day7;

import java.io.*;
import java.util.*;

public class N14500 {
	
	private static int[][] matrix;
	private static boolean[][] visited;
	private static int N = 0;
	private static int M = 0;
	private static int max = Integer.MIN_VALUE;
	
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		
		matrix = new int[N][M];
		visited = new boolean[N][M];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true; //주의: 시작지점도 방문처리
				DFS(i, j, 0, 0);
				visited = new boolean[N][M];
			}
		}
		
		System.out.print(max);
	}
	
	public static void DFS(int currentRow, int currentCol, int k, int currentSum) {
		
		//currentSum += matrix[currentRow][currentCol];
		
		if(k == 4) {
			max = Math.max(currentSum, max);

			return;
		}
				
		for(int i = 0; i < dx.length; i++) {
			int nr = currentRow + dy[i];
			int nc = currentCol + dx[i];
			
			if(!checkBoundary(nr, nc)) {
				continue;
			}
			
			if(!visited[nr][nc]) {
				if(k == 2) { //주의: ㅗ 모양 테트로미노 탐색 => 현재(current) 좌표부터 재탐색
					visited[nr][nc] = true;
					DFS(currentRow, currentCol, k + 1, currentSum + matrix[nr][nc]);
					visited[nr][nc] = false;
				}
				
				visited[nr][nc] = true;
				DFS(nr, nc, k + 1, currentSum + matrix[nr][nc]);
				visited[nr][nc] = false;
			}
		}
		
		return;
	}

	public static boolean checkBoundary(int row, int col) {
		return (row > -1 && col > -1 && row < N && col < M);
	}
}
