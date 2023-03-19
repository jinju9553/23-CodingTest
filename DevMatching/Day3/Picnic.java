package DevMatching.Day3;

import java.io.*;
import java.util.StringTokenizer;

public class Picnic { //Á¾¸¸ºÏ 157p : ¼ÒÇ³
	
	private static final int N = 10;
	private static boolean[] bucket;
	private static boolean[][] isFriend;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int C = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(C-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int numOfStudent = Integer.parseInt(st.nextToken());
			int numOfRelation = Integer.parseInt(st.nextToken());
			
			isFriend = new boolean[N][N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < numOfRelation; i++) {
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				isFriend[v][w] = true;
				isFriend[w][v] = true;
			}
			
			bucket = new boolean[numOfStudent];
			
			int count = DFS(numOfStudent, 0, 0, -1);
			sb.append(count).append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static int DFS(int N, int depth, int lastIndex, int prevIndex) { //Á¶ÇÕ
		
		if(N == depth) {
			return 1;
		}
		
		int answer = 0;
		for(int i = lastIndex; i < N; i++) {
			if(i <= prevIndex) {
				continue;
			}
			
			for(int j = i + 1; j < N; j++) {
				if(!bucket[i] && !bucket[j] && isFriend[i][j]) {
					bucket[i] = true;
					bucket[j] = true;
					
					answer += DFS(N, depth + 2, lastIndex + 1, i);
					
					bucket[i] = false;
					bucket[j] = false;
				}
			}
		}
		
		return answer;
	}

}
