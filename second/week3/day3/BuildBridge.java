package second.week3.day3;

import java.io.*;

public class BuildBridge {

	private static final int ISLAND = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		// n * n ũ�� �迭 ���� (����)
		int[][] map = new int[n][n];
		
		// ���� ���� �Է� �ޱ�
		for ( int i = 0 ; i < n ; i++ ) {
			String[] lines = br.readLine().split(" ");
			for ( int j = 0 ; j < n ; j++ ) {
				map[i][j] = Integer.parseInt(lines[j]);
			}
		}
		
		// �ִ밪 ����
		int maxDistance = 0;
		
		for ( int i = 0 ; i < n ; i++ ) {
			for ( int j = 0 ; j < n ; j++ ) {
				// ���� ��ġ�� ������ �˻�
				if ( map[i][j] == ISLAND ) {
					// ���̸� ���� ��ġ�κ��� ���Ž�� �Ͽ� ���� �Ǵ� ���ο� �ִ� ���� �Ÿ� ����, �ִ밪 ����

					// ������ 1���� �˻�
					for (int d = 1; j + d < n ; d++) {
						if ( map[i][j + d] == ISLAND ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}
					
					// ������ 1���� �˻�
					for (int d = 1; j - d > -1 ; d++) {
						if ( map[i][j - d] == ISLAND ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}
					
					
					// ������ 1���� �˻�
					for (int d = 1; i - d > -1 ; d++) {
						if ( map[i - d][j] == ISLAND ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}
					
					
					// ������ 1���� �˻�
					for (int d = 1; i + d < n ; d++) {
						if ( map[i + d][j] == ISLAND ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}
				}
			}
		}
		
		System.out.println(maxDistance);

	}
}