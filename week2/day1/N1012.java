package week2.day1;

import java.io.*;
import java.util.*;
import java.awt.Point;

public class N1012 {

	private static int[][] graph;
	private static boolean[][] visited;
	private static int answer;
	
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			answer = 0;
			
			String[] temp = br.readLine().split(" ");
			int col = Integer.parseInt(temp[0]);
			int row = Integer.parseInt(temp[1]);
			int K = Integer.parseInt(temp[2]);

			graph = new int[row][col];
			visited = new boolean[row][col];
			Queue<Point> queue = new LinkedList<>();
			
			StringTokenizer st;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				graph[y][x] = 1;
				queue.add(new Point(x, y));
			}

			for(int i = 0; i < K; i++) {
				Point p = queue.poll();
				if(!visited[p.y][p.x]) {
					BFS(p.y, p.x);
					answer++;
				}
			}

			sb.append(answer).append('\n');
			//while ³¡
		}
		
		System.out.print(sb);
	}
	
	public static void BFS(int startRow, int startCol) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(startCol, startRow));
		visited[startRow][startCol] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			int nRow = 0;
			int nCol = 0;
			for(int i = 0; i < dy.length; i++) {
				nRow = p.y + dy[i];
				nCol = p.x + dx[i];
				
				if(nRow > -1 && nCol > -1
						&& nRow < graph.length 
						&& nCol < graph[0].length) {
					if(!visited[nRow][nCol] && graph[nRow][nCol] == 1) {
						visited[nRow][nCol] = true;
						queue.add(new Point(nCol, nRow));
					}
				}
			}
		}
		return;
	}

}
