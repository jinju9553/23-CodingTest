package second.week3.day6;

import java.io.*;

public class SWEA1289 {
	
	private static int[] bits;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
            String line = br.readLine();
            int len = line.length();
            
            bits = new int[len];
            int[] answer = new int[len];
            
            for(int i = 0; i < len; i++) {
            	answer[i] = line.charAt(i) - '0';
            }
            
            int count = 0;
            for(int i = 0; i < len; i++) {
            	if(bits[i] != answer[i]) {
            		flip(i);
            		count++;
            	}
            }
            
            sb.append("#").append(test_case).append(" ").append(count).append("\n");
		}
		
		System.out.print(sb.toString());
	}

	private static void flip(int i) {
		int operand = 0;
		
		if(bits[i] == 0) {
			operand = 1;
		}
		else {
			operand = -1;
		}
		
		for(int k = i; k < bits.length; k++) {
			bits[k] += operand;
		}
	}
}
