import java.io.*;
import java.util.*;

public class Main {
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};
	
	private static int[][] matrix;
	private static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		int num = Integer.parseInt(temp[2]);
		
		matrix = new int[N][M];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++)
				matrix[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int groupIdx = Math.min(N, M) / 2;
		
		for(int i = 0; i < num; i++) 
			rotate(N, M, groupIdx);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				sb.append(matrix[i][j]).append(" ");
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void rotate(int row, int col, int groupIdx) {
		
		for(int i = 0; i < groupIdx; i++) {
			int temp = matrix[i][i]; 
			
			int count = 0;
			int currX = i; int currY = i;
			while(count < 4) {
				int nx = currX + dx[count];
				int ny = currY + dy[count];
				
				if(nx >= i && ny >= i && nx < col - i && ny < row - i) {
					matrix[currY][currX] = matrix[ny][nx];
					currX = nx;
					currY = ny;
				}
				else
					count++;
			}
			
			matrix[i + 1][i] = temp; 
		}
	}
}
