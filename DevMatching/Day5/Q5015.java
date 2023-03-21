package DevMatching.Day5;

import java.io.*;

public class Q5015 {

	private static String W = "";
	private static String S = "";
	
	private static final int IS_SAME = 1;
	private static final int IS_DIFFERENT = -1;
	private static final int NOT_CHECKED = 0;
	private static final int MAX_LENGTH = 100;
	private static int[][] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		W = br.readLine();

		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			S = br.readLine();

			DP = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
			int result = match(0, 0);

			if (result == 1) {
				sb.append(S).append('\n');
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
			if (W.charAt(wPos) == S.charAt(sPos)) {
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
