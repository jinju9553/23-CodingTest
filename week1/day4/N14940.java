package week1.day4;

import java.io.*;
import java.util.*;
import java.awt.*;

public class N14940 {

	public static int[][] matrix;
	public static int[][] answer;
	public static boolean[][] visited;
	
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = (br.readLine()).split(" ");
		int row = Integer.parseInt(temp[0]);
		int col = Integer.parseInt(temp[1]);
		
		matrix = new int[row][col];
		answer = new int[row][col];
		visited = new boolean[row][col];
		
		StringTokenizer st;
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = false;
				
				if(matrix[i][j] == 1) {
					answer[i][j] = -1;
				}
			}
		}
		
		Point p = findStart();
		BFS(p.y, p.x);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				sb.append(answer[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	public static Point findStart() {
		int targetRow = -1;
		int targetCol = -1;
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 2) {
					targetRow = i;
					targetCol = j;
					
					return new Point(targetCol, targetRow);
				}
			}
		}
		
		return new Point(0, 0);
	}
	
	public static void BFS(int row, int col) {
		Queue<Point> queue = new LinkedList<>();
		Point start = new Point(col, row);
		queue.add(start);
		
		int height = 0;
		visited[row][col] = true;
		answer[row][col] = height++;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- > 0) {
				Point p = queue.poll();
				
				int nRow = 0;
				int nCol = 0;
				for(int i = 0; i < dx.length; i++) {
					nCol = p.x + dx[i];
					nRow = p.y + dy[i];
					
					if(nCol > -1 && nRow > -1 && nRow < matrix.length && nCol < matrix[0].length) {
						if(!visited[nRow][nCol] && matrix[nRow][nCol] != 0) {
							visited[nRow][nCol] = true;
							answer[nRow][nCol] = height;
							queue.add(new Point(nCol, nRow));
						}
					}
				} 
			} 
			height++;
		} 
	}

}
