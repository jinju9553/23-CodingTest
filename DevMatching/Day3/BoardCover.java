package DevMatching.Day3;

import java.io.*;

public class BoardCover { //Á¾¸¸ºÏ 160p : °ÔÀÓÆÇ µ¤±â
	
	private static char[][] board;
	private static int dx[][] = {{0, 0, 1}, {0, 1, 0}, {0, 1, 1}, {0, 0, -1}};
	private static int dy[][] = {{0, 1, 1}, {0, 0, 1}, {0, 0, 1}, {0, 1,  1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int C = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(C-- > 0) {
			String[] temp = br.readLine().split(" ");
			int row = Integer.parseInt(temp[0]);
			int col = Integer.parseInt(temp[1]);
			
			board = new char[row][col];
			
			int numOfWhite = 0;
			for(int i = 0; i < row; i++) {
				String line = br.readLine();
				for(int j = 0; j < col; j++) {
					board[i][j] = line.charAt(j);
					
					if(board[i][j] == '.') {
						numOfWhite += 1;
					}
				}
			}
		
			int answer = 0;
			if(numOfWhite % 3 == 0) {
				answer = DFS(board);
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int DFS(char[][] board) {
		
		int row = -1;
		int col = -1;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == '.') { //°¡Àå ¿ÞÂÊ À§ Èò Ä­À» Ã£¾Ò´Ù¸é
					row = i;
					col = j;
					break;
				}
			}
			
			if(row != -1) {
				break;
			}
		}
		
		if(row == -1) { //À§ÀÇ ¹Ýº¹¹®¿¡¼­ ¹ß°ßµÈ Èò Ä­ÀÌ ¾øÀ½ => ¸ðµÎ ´Ù µ¤À½
			return 1;
		}
		
		int answer = 0;
		
		int nx = 0; 
		int ny = 0;
		boolean isPossible = true;
		for(int i = 0; i < dx.length; i++) {
			//¼¼ Ä­À¸·Î µ¤¾îº»´Ù
			isPossible = true;
			for(int j = 0; j < dx[0].length; j++) {
				ny = row + dy[i][j];
				nx = col + dx[i][j];
				
				if(!checkBoundary(nx, ny)) {
					isPossible = false;
				}
			}
			
			if(isPossible) { //¼¼ Ä­ ´Ù ¹üÀ§¸¦ ¹þ¾î³ªÁö ¾Ê´Â´Ù¸é
				for(int j = 0; j < dx[0].length; j++) {
					ny = row + dy[i][j];
					nx = col + dx[i][j];
					
					board[ny][nx] = '#';
				}
				
				answer += DFS(board);
				
				for(int j = 0; j < dx[0].length; j++) { //¿øº¹
					ny = row + dy[i][j];
					nx = col + dx[i][j];
					
					board[ny][nx] = '.';
				}
			}
		}
		
		return answer;
	}
	
	public static boolean checkBoundary(int nx, int ny) {
		boolean isWithinBoundary = (nx > -1 && ny > -1 && nx < board[0].length && ny < board.length);
		boolean isWhite = false;
		
		if(isWithinBoundary && board[ny][nx] == '.') {
			isWhite = true;
		}
		
		return (isWithinBoundary && isWhite);
	}
}
