package SWM.Day1;

import java.io.*;

public class N8958 { //25분 소모
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		char[] answers;
		
		while(T-- > 0) {
			String line = br.readLine();
			int len = line.length(); //length는 최대 80 => O(80) = O(1)
			answers = new char[len];
			
			for(int i = 0; i < len; i++) {
				answers[i] = line.charAt(i);
			}
			
			int score = 0;
			int point = 1;
			for(int i = 0; i < len; i++) {
				if(answers[i] == 'O') {
					score += point;
					point++;
				}
				else if(answers[i] == 'X') {
					point = 1;
				}
			}
			
			System.out.println(score);
		}

	}

}
