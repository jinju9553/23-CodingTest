package SWM.Day11;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.awt.Point;

public class N9663 {

	private static boolean[][] visited;
	
	private static int N;
	private static int answer = 0;
	
	private static int[] dx = {-1, 1, -1, 1, -2, 2, -2, 2};
	private static int[] dy = {-2, -2, 2, 2, -1, -1, 1, 1};
	private static Queue<Point> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				visited = new boolean[N][N];
				queue = new LinkedList<>();
				solution(x, y, 1); //현재 (i, j)에 퀸이 하나 있으므로 1에서 시작
			}
		}
		
		System.out.print(answer);
	}
	
	public static void solution(int x, int y, int k) {
		
		visited[y][x] = true;
		
		if(N == k) {
			answer++;
			return;
		}
		
		int nx = 0;
		int ny = 0;
		for(int i = 0; i < dy.length; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(isReachable(nx, ny)) {
				queue.add(new Point(nx, ny));
			}
		}
		
		for(int i = 0; i < dy.length; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			Point p = new Point(nx, ny);
			if(isReachable(nx, ny)) {
				if(!visited[ny][nx] && queue.contains(p)) {
					solution(nx, ny, k + 1);
					queue.poll();
				}
			}
		}
		
		return;
	}
	
	public static boolean isReachable(int nx, int ny) {
		return (nx > -1 && ny > -1 && nx < N && ny < N);
	}

}
