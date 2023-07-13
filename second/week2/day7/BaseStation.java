package second.week2.day7;

import java.io.*;

public class BaseStation {

	private static final char HOUSE = 'H';
	private static final char NONE = 'X';
	
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	
	private static char[][] matrix;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			matrix= new char[n][n];
			for (int i = 0; i < n; i++) {
				String lines = br.readLine();
				for (int j = 0; j < n; j++) {
					matrix[i][j] = lines.charAt(j);
				}
			}
			
			// 1.커버되지 않는 집을 체크한다.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(matrix[i][j] == 'A' || matrix[i][j] == 'B'
							|| matrix[i][j] == 'C') {
						countHouses(i, j, matrix[i][j]);
					}
				}
			}
			
			// 2.전체 집의 수를 센다
			int houses = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(matrix[i][j] == HOUSE) {
						houses += 1;
					}
				}
			}

			sb.append("#" + tc + " ").append(houses).append("\n");
		}
		
		System.out.print(sb);
	}

	private static void countHouses(int row, int col, char type) {
		int scope = 0;
		
		if(type == 'A') {
			scope = 1;
		}
		else if(type == 'B') {
			scope = 2;
		}
		else if(type == 'C') {
			scope = 3;
		}

		for(int k = 1; k <= scope; k++) {
			int nr = 0;
			int nc = 0;
			for(int i = 0; i < dx.length; i++) {
				nr = row + dy[i] * k;
				nc = col + dx[i] * k;
				
				if(!isValidIndex(nr, nc)) {
					continue;
				}
				
				//주의: 집의 개수를 빼게 된다면 동시에 겹치는 집을 두 번 뺄 수도 있다.
				if(matrix[nr][nc] == HOUSE) {
					matrix[nr][nc] = NONE;
				}
			}
		}

		return;
	}

	private static boolean isValidIndex(int nr, int nc) {
		return (nr > -1 && nc > -1 && nr < matrix.length && nc < matrix.length);
	}

}
