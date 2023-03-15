package SWM.Day3;

import java.io.*;
import java.util.StringTokenizer;

public class N6550 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String lines; //= br.readLine();
		while(!(lines = br.readLine()).equals("")) {
			st = new StringTokenizer(lines, " ");
			String subString = st.nextToken();
			String entireString = st.nextToken();
			
			int subLen = subString.length();
			int entireLen = entireString.length();
			int count = 0;
			
			int idx = 0;
			for(int i = 0; i < entireLen; i++) {
				if(subString.charAt(idx) == entireString.charAt(i)) {
					count++;
					idx++;
				}
				
				if(idx >= subLen) {
					break;
				}
			}
			
			if(count == subLen) { //Á¶°Ç¹® Ä¸½¶È­ ÇÊ¿ä
				sb.append("Yes").append("\n");
			}
			else {
				sb.append("No").append("\n");
			}
		}	
		
		System.out.print(sb);
	}
}
