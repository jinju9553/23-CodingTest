import java.awt.Point;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
		
	private static int N;
	private static int M;
	private static int K;
	private static int answer = Integer.MAX_VALUE;
	
	private static int[][] matrix;
	private static int[] permutation;
	private static boolean[] visited;
	private static String[] operations;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		K = Integer.parseInt(temp[2]);
		
		matrix = new int[N][M];

		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		operations = new String[K];
		for(int i = 0; i < K; i++) {
			operations[i] = br.readLine();
		}
		
		permutation = new int[K];
		visited = new boolean[K];
		dfs(0);
		
		bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
	}
	
	private static void dfs(int depth) {
		if(depth == K) {
			int[][] resultMat = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					resultMat[i][j] = matrix[i][j];
				}
			}
			
			//1.연산 순서대로 회전
			for(int i = 0; i < K; i++) {
				int idx = permutation[i];
				StringTokenizer st = new StringTokenizer(operations[idx], " ");
				
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				int groupIdx = (s * 2 + 1) / 2;
				rotate(resultMat, 
						new Point(r - s - 1, c - s - 1), new Point(r + s - 1, c + s - 1), groupIdx);
			}	
			
			//2.결과 계산
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = 0; j < M; j++) {
					sum += resultMat[i][j];
				}
				answer = Math.min(sum, answer);
			}
			
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(visited[i]) {
				continue;
			}
			
			visited[i] = true;
				
			permutation[depth] = i;
			dfs(depth + 1);
			
			visited[i] = false;
		}
	}

	public static int[][] rotate(int[][] mat, Point start, Point end, int groupIdx) {
		int startX = start.x;
		int startY = start.y;
		int endX = end.x;
		int endY = end.y;
		
		for(int i = 0; i < groupIdx; i++) {
			int temp = mat[startY + i][startX + i]; 
			
			int count = 0;
			int currX = startX + i; int currY = startY + i;
			while(count < 4) {
				int nx = currX + dx[count];
				int ny = currY + dy[count];
				
				if(nx >= startX + i && ny >= startY + i 
						&& nx <= endX - i && ny <= endY - i) {
					mat[currY][currX] = mat[ny][nx];
					currX = nx;
					currY = ny;
				}
				else
					count++;
			}
			
			mat[startY + i][startX + i + 1] = temp; 
		}
		
		return mat;
	}
}
