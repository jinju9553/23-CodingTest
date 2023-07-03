package second.week1.day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA12712 {

	private static int[] pdx = {1, 0, -1, 0};
	private static int[] pdy = {0, 1, 0, -1};

	private static int[] cdx = {1, 1 , -1, -1};
	private static int[] cdy = {1, -1, 1, -1};
	
	private static int[][] matrix;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] temp = br.readLine().split(" ");
            
            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);
            
            matrix = new int[N][N];
            for(int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for(int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int plusResult = 0;
            int crossResult = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                	int result1 = calculatePlusShape(M, i, j);
                	int result2 = calculateCrossShape(M, i, j);
                	
                	plusResult = Math.max(result1, plusResult);
                	crossResult = Math.max(result2, crossResult);
                }
            }
            
            int answer = Math.max(plusResult, crossResult);
            
            sb.append("#" + test_case + " ").append(answer).append("\n");
		}
        
        System.out.print(sb);
	}

	private static int calculatePlusShape(int M, int row, int col) {
		int sum = 0;
		
		sum += matrix[row][col]; //중심점
		
		for(int m = 1; m < M; m++) {
			sum += sumByDelta(m, row, col, pdx, pdy);
		}
		
		return sum;
	}

	private static int calculateCrossShape(int M, int row, int col) {
		int sum = 0;
		
		sum += matrix[row][col]; //중심점
		
		for(int m = 1; m < M; m++) {
			sum += sumByDelta(m, row, col, cdx, cdy);
		}
		
		return sum;
	}

	private static int sumByDelta(int m, int row, int col, int[] dx, int[] dy) {
		int rslt = 0;
		
		for(int i = 0; i < dx.length; i++) {
			int nr = row + (dy[i] * m);
			int nc = col + (dx[i] * m);
			
			if(!isValidIndex(nr, nc, matrix.length)) {
				continue; //break로 반복을 종료해버리지 않게 주의
			}
			
			rslt += matrix[nr][nc];
		}
		
		return rslt;
	}

	private static boolean isValidIndex(int nr, int nc, int N) {
		return (nr > -1 && nc > -1 && nr < N && nc < N);
	}

}
