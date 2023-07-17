package second.week3.day3;

import java.io.*;

public class BuildBridge {

	private static final int ISLAND = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		// n * n 크기 배열 선언 (지도)
		int[][] map = new int[n][n];
		
		// 지도 정보 입력 받기
		for ( int i = 0 ; i < n ; i++ ) {
			String[] lines = br.readLine().split(" ");
			for ( int j = 0 ; j < n ; j++ ) {
				map[i][j] = Integer.parseInt(lines[j]);
			}
		}
		
		// 최대값 저장
		int maxDistance = 0;
		
		for ( int i = 0 ; i < n ; i++ ) {
			for ( int j = 0 ; j < n ; j++ ) {
				// 지금 위치가 섬인지 검사
				if ( map[i][j] == ISLAND ) {
					// 섬이면 현재 위치로부터 사방탐색 하여 가로 또는 세로에 있는 섬과 거리 측정, 최대값 저장

					// 동쪽이 1인지 검사
					for (int d = 1; j + d < n ; d++) {
						if ( map[i][j + d] == ISLAND ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}
					
					// 서쪽이 1인지 검사
					for (int d = 1; j - d > -1 ; d++) {
						if ( map[i][j - d] == ISLAND ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}
					
					
					// 북쪽이 1인지 검사
					for (int d = 1; i - d > -1 ; d++) {
						if ( map[i - d][j] == ISLAND ) {
							maxDistance = Math.max( maxDistance , d );
							break;
						}
					}
					
					
					// 남쪽이 1인지 검사
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