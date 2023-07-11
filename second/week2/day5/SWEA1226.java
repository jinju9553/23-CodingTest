package second.week2.day5;

import java.util.*;
import java.awt.Point;
import java.io.*;

public class SWEA1226 {

	private static final int N = 16;
    
	private static final int PATH = 0;
	private static final int WALL = 1;
	private static final int DEST = 3;
	
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	
    private static int[][] matrix;
    private static boolean[][] visited;
        
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 1;
        
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
            String testCaseNum = br.readLine();
            
            matrix = new int[N][N];
            visited = new boolean[N][N];
            
            for(int i = 0; i < N; i++) {
                String lines = br.readLine();
            	for(int j = 0; j < N; j++) {
                	matrix[i][j] = lines.charAt(j) - '0';
                }
            }
            
            int result = BFS(1, 1); //(r, c) 대신 (x, y) 사용, 첫 칸이(0, 0)
            
            sb.append("#" + test_case + " ").append(result).append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static int BFS(int startX, int startY) {
		Queue<Point> queue = new LinkedList<>();
		
		visited[startY][startX] = true;
		queue.add(new Point(startX, startY));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(matrix[p.y][p.x] == DEST) {
				return 1;
			}
			
			int nx = 0;
			int ny = 0;
			for(int i = 0; i < dx.length; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				
				if(!isValidIndex(nx, ny) || matrix[ny][nx] == WALL) {
					continue;
				}
				
				//벽이 아니고(1, 3) 방문한 적 없다면
				if(!visited[ny][nx]) {
					visited[ny][nx] = true;

					queue.add(new Point(nx, ny));
				}
			}
		}
		
		return 0;
	}
	
	public static boolean isValidIndex(int nx, int ny) {
		return (nx > -1 && ny > -1 && nx < N && ny < N);
	}
}
