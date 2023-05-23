package week9.day2;

import java.io.*;
import java.util.*;

public class Q4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<String> sentences = new ArrayList<>();
		
		while(true) {
			String line = br.readLine();
			
			if(line.equals(".")) {
				break;
			}
			
			sentences.add(line);
		}
		
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		boolean balanced = true;
		for(String sentence : sentences) {
			int length = sentence.length();
			
			for(int i = 0; i < length; i++) {
				char c = sentence.charAt(i);
				
				if(c == '(' || c == '[') {
					stack.push(c);
				}
				
				if(c == ')' || c == ']') {
					if(stack.size() <= 0) {
						balanced = false;
						break;
					}
					
					char bracket = stack.pop();
					
					if(!matches(c, bracket)) {
						balanced = false;
						break;
					}
				}
			}
			
			if (stack.size() > 0) {
				sb.append("no").append('\n');
			}
			else if(balanced == true) {
				sb.append("yes").append('\n');
			}
			else if(balanced == false) {
				sb.append("no").append('\n');
			}
			
			balanced = true;
			stack.clear();
		}
		
		System.out.print(sb);
	}

	private static boolean matches(char c, char bracket) {
		if(bracket == '(' && c == ')'
			|| bracket == '[' && c == ']') {
			return true;
		}
		
		return false;
	}

}
