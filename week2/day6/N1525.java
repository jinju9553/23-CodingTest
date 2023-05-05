package week2.day6;

import java.io.*;
import java.util.*;

public class N1525 {
	
	public static final int N = 3;
	public static final String ANSWER = "123456780";
	public static Map<String, Integer> map = new HashMap<>();
	
	public static int[] dx = {0, 1, 0, -1}; //퍼즐의 이동
	public static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String initialState = "";
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				initialState += st.nextToken();
			}
		}
		
		int answer = BFS(initialState);
		System.out.print(answer);
	}
	
	public static int BFS(String initialState) {
		Queue<String> queue = new LinkedList<>();
		int width = 0;
		//matrix 탐색이 아니기 때문에 visited 필요 없음
		
		queue.add(initialState);
		map.putIfAbsent(initialState, 0);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- > 0) {
				String s = queue.poll();
				
				if(s.equals(ANSWER)) {
					return width;
				}
			
				int zeroIdx = s.indexOf('0');
				int zeroRow = zeroIdx / N;
				int zeroCol = zeroIdx % N;
				
				int nx = 0;
				int ny = 0;
				for(int i = 0; i < dx.length; i++) {
					nx = zeroCol + dx[i];
					ny = zeroRow + dy[i];
					
					if(checkBoundary(nx, ny)) {
						int swapIdx = (ny * 3) + nx;
						char newChar = s.charAt(swapIdx);
						
						String nextStr = s.replace(newChar, '9');
						nextStr = nextStr.replace('0', newChar);
						nextStr = nextStr.replace('9', '0');
						
						//중복방문 할 수 없기 때문에 존재하는 부분(visited의 기능!!)
						if(!map.containsKey(nextStr)) {
							queue.add(nextStr);
							map.put(nextStr, width);
						}
					}
				}
			}
			width += 1;
		}
		
		return -1;
	}
	
	public static boolean checkBoundary(int x, int y) {
		return (x > -1 && y > -1 && x < N && y < N);
	}

}
