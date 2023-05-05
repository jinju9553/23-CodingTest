package week2.day1;

import java.io.*;

public class N5525_2 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int p_num = Integer.parseInt(br.readLine());
		int s_length = Integer.parseInt(br.readLine());
		int p_length = 2 * p_num + 1;

		String s = br.readLine();

		int[] DP = new int[s_length];

		int answer = 0;
		for (int i = 1; i < s_length - 1; i++) {
			int o_idx = i;
			int i_idx = i + 1;

			if (s.charAt(o_idx) == 'O' && s.charAt(i_idx) == 'I') {
				DP[i_idx] = DP[i_idx - 2] + 1;

				if (DP[i_idx] >= p_num && i_idx >= p_length - 1) {
					if (s.charAt(i_idx - (p_length - 1)) == 'I') {
						answer++;
					}
				}
			}
		}
		System.out.print(answer);
	}
}
