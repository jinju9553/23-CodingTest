package week2.day6;

import java.io.*;

public class N9663 {
	
	private static int[] board;
	private static int N;
	private static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new int[N];

		DFS(0);
		
		System.out.print(answer);
	}
	
	public static void DFS(int k) {
		if(N == k) { //백트랙킹 기본 형태 (종료조건)
			answer += 1;
			
			return;
		}
		
		for(int i = 0; i < N; i++) { //0열부터 N - 1열까지 아무데나 놓아도 됨 (중복체크 X)
			board[k] = i; //순열이나 조합 뽑는 방식이랑 같음
			
			if(isReachable(k)) { //다음(k + 1)에 놓을 수 있는 칸이 있다면 (중복체크는 여기서)
				DFS(k + 1); //추가로 탐색한다.
			}
		}
	}
	
	public static boolean isReachable(int row) {
		for(int i = 0; i < row; i++) {
			//1.직선으로 퀸이 놓인 경우 (현재 선택한 열 = 이미 무언가가 놓인 열)
			if(board[row] == board[i]) {
				return false;
			}

			//2.대각선으로 퀸이 놓인 경우 (행의 차와 열의 차가 같다면 대각선에 놓임) 
			if(Math.abs(row - i) == Math.abs(board[row] - board[i])) {
				return false;
			}
		}
		
		return true;
	}

}
