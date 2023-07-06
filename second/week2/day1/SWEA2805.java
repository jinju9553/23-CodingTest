package second.week2.day1;

import java.io.*;

public class SWEA2805 {
	
	public static void main(String args[]) throws IOException { //10:58~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
            
            int[][] farm = new int[N][N];
            for(int i = 0; i < N; i++) {
                String line = br.readLine();
            	for(int j = 0; j < N; j++) {
                	farm[i][j] = line.charAt(j) - '0';
                }
            }
            
            int mid = N / 2;
            
            int sum = 0;
            for(int i = 0; i < N; i++) {
                int start = Math.abs(mid - i);
                int end = N - start;
                for(int j = start; j < end; j++) {
                	sum += farm[i][j];
                }
            }
            
            sb.append("#" + test_case + " ").append(sum).append("\n");
		}
        
        System.out.print(sb);
	}
}