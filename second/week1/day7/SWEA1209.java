package second.week1.day7;

import java.io.*;

public class SWEA1209 {

private static final int N = 100;
    
    private static int[][] matrix;
    
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
        
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
            String testCaseNum = br.readLine();
            matrix = new int[N][N];
            
            for(int i = 0; i < N; i++) {
                String[] temp = br.readLine().split(" ");
            	for(int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(temp[j]);
                }
            }
            
            int max = -1;
            int sum = 0;
            
            //1. 행의 합
            for(int i = 0; i < N; i++) {
                sum = 0;
            	for(int j = 0; j < N; j++) {
                    sum += matrix[i][j];
                }
                
                max = Math.max(sum, max);
            }
            
            //2. 열의 합
            for(int j = 0; j < N; j++) {
                sum = 0;
            	for(int i = 0; i < N; i++) {
                    sum += matrix[i][j];
                }
                
                max = Math.max(sum, max);
            }
            
            //3. 대각선 합
            sum = 0;
            for(int i = 0; i < N; i++) {
                sum += matrix[i][i];
            }
            max = Math.max(sum, max);
            
            sum = 0;
            for(int i = 0; i < N; i++) {
                sum += matrix[i][N - i - 1];
            }
            max = Math.max(sum, max);
            
            sb.append("#" + test_case + " ").append(max).append("\n");
		}
        
        System.out.print(sb);
	}

}
