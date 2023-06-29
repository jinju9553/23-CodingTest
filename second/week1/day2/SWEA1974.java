package second.week1.day2;

import java.util.*;
import java.io.*;

public class SWEA1974 {

	private static int N = 9;
    
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			int[][] board = new int[N][N];
            
            for(int i = 0; i < N; i++) {
                String[] temp = br.readLine().split(" ");
                for(int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(temp[j]);
                }
            }
            
            boolean rowResult = checkRow(board);
            boolean colResult = checkCol(board);
            boolean matrixResult = checkMatrix(board);
            
            int answer = 0;
            if(rowResult && colResult && matrixResult) {
                answer = 1;
            }
            
            sb.append("#" + test_case + " ").append(answer).append("\n");
		}
        
        System.out.print(sb);
	}
    
    public static boolean checkRow(int[][] board) {
        Set<Integer> set = new HashSet<>();
        
        for(int j = 0; j < N; j++) {
        	for(int i = 0; i < N; i++) {
        		if(set.contains(board[i][j])) {
        			return false;
        		}
        		
        		set.add(board[i][j]);
        	}
        	set.clear();
        }
        
    	return true;
    }
    
    public static boolean checkCol(int[][] board) {
    	Set<Integer> set = new HashSet<>();
    	
    	for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(set.contains(board[i][j])) {
        			return false;
        		}
        		
        		set.add(board[i][j]);
        	}
        	set.clear();
        }
    	
    	return true;
    }
    
    public static boolean checkMatrix(int[][] board) {
    	Set<Integer> set = new HashSet<>();
    	int row = 0;
    	int col = 0;
    	
    	for(int k = 0; k < N; k++) {
    		for(int i = row; i < row + 3; i++) {
            	for(int j = col; j < col + 3; j++) {
            		if(set.contains(board[i][j])) {
            			return false;
            		}
            		set.add(board[i][j]);
            	}
            }
        	col += 3;
        	
        	if(col >= N) {
        		col = 0;
        		row += 3;
        	}
        	
        	set.clear();
    	}
    	
    	return true;
    }

}
