package second.week4.day1;

import java.io.*;

public class BOJ2810 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		int result = 0;
		if(input.charAt(0) == 'S') {
			result += 2;
		}
		else {
			result += 1;
		}
		
		boolean isStarted = true;
		for(int i = 1; i < N; i++) {
			char prev = input.charAt(i - 1);
			char curr = input.charAt(i);
			
			if(prev == 'S' && curr == 'L') {
				isStarted = true;
			}
			else if(prev == 'S' && curr == 'S') {
				result += 1;
			}
			else if(prev == 'L' && curr == 'S') {
				result += 1;
			}
			else if(prev == 'L' && curr == 'L') {
				if(isStarted) {
					isStarted = false;
					result += 1;
				} else {
					isStarted = true;
				}
			}
		}
		
		if(result > N) {
			result = N;
		}
		
		System.out.println(result);
	}

}
