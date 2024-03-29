import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {

	private static int N;
	private static int L;
	private static long I;
	
	private static long[][] DP;
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		N = Integer.parseInt(temp[0]);
		L = Integer.parseInt(temp[1]);
		I = Long.parseLong(temp[2]); //최대 2^31
		
		DP = new long[N + 1][N + 1]; //N자리 비트에 0~N개의 1이 있는 경우의 수
		
		DP[0][0] = 1;
		
		for(int n = 1; n <= N; n++) {
			DP[n][0] = 1; //0으로 채운 경우의 수는 1개
			for(int m = 1; m <= L; m++) { //1을 0~L개까지 채운다.
				//DP[n][m] = n - 1 자리의 비트에 1을 붙이거나, 0을 붙이거나
				DP[n][m] = DP[n - 1][m - 1] + DP[n - 1][m];
			}
		}

		find(N, L, I);
		
		System.out.println(sb);
	}
	
	private static void find(int N, int L, long I) {
		for (int pos = N; pos > 0; --pos) {
			long pivot = 0; //n - 1자리 비트에 1을 0~L개 채운 모든 경우의 수
			for(int i = 0; i < L + 1; i++) {
				pivot += DP[pos - 1][i];
			}

            int currDigit;
            if (pivot < I) {
            	currDigit = 1;
                I -= pivot;
                L--;
            } else currDigit = 0;

            sb.append(currDigit);
        }
	}
}
