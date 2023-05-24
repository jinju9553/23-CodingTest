package week9.day3;

import java.io.*;
import java.util.*;

public class Q9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String explosion = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		String result = input;
		int expIdx = explosion.length() - 1;
		while(result.contains(explosion)) {
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < result.length(); i++) {
				stack.add(result.charAt(i));
			}
			
			int size = stack.size();
			for(int i = 0; i < size; i++) {
				char curr = stack.pop();
				
				if(expIdx >= 0 && curr == explosion.charAt(expIdx)) {
					expIdx--;
					continue;
				}
				
				sb.append(curr);
				
				if(expIdx == -1) {
					expIdx = explosion.length() - 1;
				}
			}
			
			result = sb.reverse().toString();
		}
		
		if(result.length() == 0) {
			System.out.print("FRULA");
		}
		else {
			System.out.print(result);
		}
	}

}
