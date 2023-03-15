package SWM.Day5;

import java.io.*;

public class N14584 {
	
	public static int SIZE = ('z' - 'a') + 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String cryptogram = br.readLine();
		int num = Integer.parseInt(br.readLine());
		String[] dict = new String[num];
		
		for(int i = 0; i < num; i++) {
			dict[i] = br.readLine();
		}
		
		//1.알파벳 밀기
		String answer = "";
		for(int i = 0; i < SIZE; i++) {
			String result = decryption(cryptogram, i);
			
			//2.contain하는지 확인하기
			for(int j = 0; j < dict.length; j++) {
				if(result.contains(dict[j])) {
					answer = result;
				}
			}
			
			if(!answer.equals("")) {
				break;
			}
		}
		
		System.out.print(answer);
	}
	
	public static String decryption(String cryptogram, int scale) {
		char[] lines = cryptogram.toCharArray();
		
		for(int i = 0; i < lines.length; i++) {
			int gap = (lines[i] - 'a') + scale;
			char ch = (char)((gap % SIZE) + 'a');
			
			lines[i] = ch;
		}
		
		return String.valueOf(lines);
	}
}
