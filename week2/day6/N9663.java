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
		if(N == k) { //��Ʈ��ŷ �⺻ ���� (��������)
			answer += 1;
			
			return;
		}
		
		for(int i = 0; i < N; i++) { //0������ N - 1������ �ƹ����� ���Ƶ� �� (�ߺ�üũ X)
			board[k] = i; //�����̳� ���� �̴� ����̶� ����
			
			if(isReachable(k)) { //����(k + 1)�� ���� �� �ִ� ĭ�� �ִٸ� (�ߺ�üũ�� ���⼭)
				DFS(k + 1); //�߰��� Ž���Ѵ�.
			}
		}
	}
	
	public static boolean isReachable(int row) {
		for(int i = 0; i < row; i++) {
			//1.�������� ���� ���� ��� (���� ������ �� = �̹� ���𰡰� ���� ��)
			if(board[row] == board[i]) {
				return false;
			}

			//2.�밢������ ���� ���� ��� (���� ���� ���� ���� ���ٸ� �밢���� ����) 
			if(Math.abs(row - i) == Math.abs(board[row] - board[i])) {
				return false;
			}
		}
		
		return true;
	}

}
