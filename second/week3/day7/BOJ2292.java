package second.week3.day7;

import java.io.*;

public class BOJ2292 {

	private static int MAX = 1_000_000_000;
	private static int CYCLE = 6;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int base = 1;
		int answer = 0;
		for(int k = 0; k < MAX; k++) {
			if(base + CYCLE * k >= N) {
				answer = k + 1;
				break;
			}
			
			base = base + CYCLE * k;
		}
		
		System.out.println(answer);
	}

}
