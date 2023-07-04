package second.week1.day6;

import java.io.*;
import java.util.*;
import java.awt.*;

public class SWEA1868 {

	private static final char NONE = '.';
	private static final char BOMB = '*';

	private static int[] dx = { 0, 1, 0, -1, 1, 1, -1, -1 };
	private static int[] dy = { 1, 0, -1, 0, 1, -1, 1, -1 };

	private static char[][] matrix;
	private static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());

			matrix = new char[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					matrix[i][j] = line.charAt(j);
				}
			}

			// 1.숫자를 표시한다
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][j] == NONE) {
						matrix[i][j] = '0';
					}

					if (matrix[i][j] == BOMB) {
						countBombs(i, j);
						visited[i][j] = true; // 지뢰를 사전에 표시
					}
				}
			}

			// 2.영역의 개수를 센다
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) { //사전에 표시된 지뢰와 방문한 정점을 모두 패스
						continue;
					}

					BFS(i, j);
					answer += 1;
				}
			}
			
			sb.append("#" + test_case + " ").append(answer).append("\n");
		}

		System.out.print(sb);
	}

	private static void countBombs(int startR, int startC) {
		int nr = 0;
		int nc = 0;

		for (int i = 0; i < dx.length; i++) {
			nr = startR + dy[i];
			nc = startC + dx[i];

			if (!isValidIndex(nr, nc)) {
				continue;
			}

			if (matrix[nr][nc] == NONE) {
				matrix[nr][nc] = '0';
			}

			if (matrix[nr][nc] != BOMB) {
				matrix[nr][nc] += 1;
			}
		}

		return;
	}

	private static void BFS(int startR, int startC) {
		Queue<Point> queue = new LinkedList<>();

		visited[startR][startC] = true;
		queue.add(new Point(startC, startR));

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			int nr = 0;
			int nc = 0;
			for (int i = 0; i < dx.length; i++) {
				nc = p.x + dx[i];
				nr = p.y + dy[i];

				if (!isValidIndex(nr, nc)) {
					continue;
				}

				if (!visited[nr][nc]) {
					if(matrix[p.y][p.x] == '0') { // 0을 눌렀다면
						visited[nr][nc] = true; //주변을 모두 해금
					}
					
					if (matrix[nr][nc] == '0') { // 인접 정점이 0이라면 큐에 추가
						visited[nr][nc] = true;
						queue.add(new Point(nc, nr));
					}
				}
			}
		}

		return;
	}

	private static boolean isValidIndex(int nr, int nc) {
		return (nr > -1 && nc > -1 && nr < matrix.length && nc < matrix.length);
	}

}
