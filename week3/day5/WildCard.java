package week3.day5;

import java.io.*;

public class WildCard { //종만북: 와일드카드 O(n^3)

	private static String W = "";
	private static String S = "";
	
	private static final int IS_SAME = 1;
	private static final int IS_DIFFERENT = -1;
	private static final int NOT_CHECKED = 0;
	private static final int MAX_LENGTH = 100;
	private static int[][] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int C = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(C-- > 0) {
			W = br.readLine();
					
			int num = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < num; i++) {
				S = br.readLine();
				
				DP = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
				int result = match(0, 0);
				
				if(result == 1) {
					sb.append(S).append('\n');
				}
			}
		}
		
		System.out.print(sb);
	}
	
	private static int match(int wPos, int sPos) {
		
		int result = DP[wPos][sPos];
		
		if(result != NOT_CHECKED) {
			return result;
		}
		
		while(wPos < W.length() && sPos < S.length()) {
			if ((W.charAt(wPos) == '?') || W.charAt(wPos) == S.charAt(sPos)) {
				++wPos;
				++sPos;
			}
			else {
				break;
			}
		}
		
		if(wPos == W.length()) {
			if(sPos == S.length()) {
				DP[wPos][sPos] = IS_SAME;
				return DP[wPos][sPos];
			}
			
			DP[wPos][sPos] = IS_DIFFERENT;
			return DP[wPos][sPos];
		}
		
		if(W.charAt(wPos) == '*') {
			for(int skip = 0; skip <= S.length() - sPos; skip++) {
				if(match(wPos + 1, sPos + skip) == IS_SAME) {
					DP[wPos][sPos] = IS_SAME;
					return DP[wPos][sPos];
				}
			}
		}
		
		DP[wPos][sPos] = IS_DIFFERENT;
		
		return DP[wPos][sPos];
	}
}
