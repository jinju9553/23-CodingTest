import java.io.*;

public class Main {

	public static int[] DP;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int target = Integer.parseInt(br.readLine());
		
		DP = new int[target + 1];
		
		for(int i = 1; i <= target; i++) {
			DP[i] = Integer.MAX_VALUE;
		}
		
		DP[1] = 0;
		
		for(int n = 1; n < target; n++) {
			if(n + 1 <= target) {
				DP[n + 1] = Math.min(DP[n] + 1, DP[n + 1]);
			}
			if((2 * n) <= target) {
				DP[2 * n] = Math.min(DP[n] + 1, DP[2 * n]);
			}
			if((3 * n) <= target) {
				DP[3 * n] = Math.min(DP[n] + 1, DP[3 * n]);
			}
		}
		
		System.out.println(DP[target]);
	}
	
}
