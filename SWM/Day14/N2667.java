package SWM.Day14;

import java.io.*;
import java.util.*;
import java.util.List;
import java.awt.*;

public class N2667 { //15:03 Ω√¿€ - 15:28 ≥°

	private static int T;
	private static int numOfHouse = 0;
	private static int numOfComplex = 0;
	
	private static int[][] matrix;
	private static boolean[][] visited;
	
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		matrix = new int[T][T];
		visited = new boolean[T][T];
		
		for(int i = 0; i < T; i++) {
			String line = br.readLine();
			for(int j = 0; j < T; j++) {
				matrix[i][j] = line.charAt(j) - '0';
			}
		}
		
		List<Integer> houses = new LinkedList<>();
		for(int i = 0; i < T; i++) {
			for(int j = 0; j < T; j++) {
				if(!visited[i][j] && matrix[i][j] == 1) {
					BFS(i, j);
					numOfComplex++;
					houses.add(numOfHouse);
					numOfHouse = 0;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(numOfComplex).append('\n');
		
		Collections.sort(houses);
		for(int n : houses) {
			sb.append(n).append('\n');
		}
		
		System.out.print(sb);
	}
	
	private static void BFS(int startRow, int startCol) {
		Queue<Point> queue = new LinkedList<>();
		
		visited[startRow][startCol] = true;
		queue.add(new Point(startCol, startRow));
		numOfHouse++;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			int nx = 0;
			int ny = 0;
			for(int i = 0; i < dx.length; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				
				if(nx > -1 && ny > -1 && nx < T && ny < T) {
					if(!visited[ny][nx] && matrix[ny][nx] == 1) {
						visited[ny][nx] = true;
						queue.add(new Point(nx, ny));
						numOfHouse++;
					}
				}
			}
		}
	}

}
