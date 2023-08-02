import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			int length = Integer.parseInt(br.readLine());
            int result = 1;
            
            String lines = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < length; i++) {
            	char c = lines.charAt(i);
                
                if(c == '(' || c == '[' || c == '{' || c == '<') {
                	stack.add(c);
                }
                else if(stack.isEmpty()) {
                    result = 0;
                    break;
                }
                else {
                	char q = stack.pop();
                    
                    switch(q) {
                        case '(' : {
                            if( c != ')' ) {
                                result = 0;
                            } 
                            break;
                        }
                        case '[' : {
                            if(c != ']') {
                                result = 0;
                            } 
                            break;
                        }
                        case '{' : {
                            if(c != '}') {
                                result = 0;
                            } 
                            break;
                        }
                        case '<' : {
                            if(c != '>') {
                                result = 0;
                            } 
                            break;
                        }
                    }
                    
                    //
                }
            }

            sb.append("#" + test_case + " ").append(result).append("\n");
		}
        
        System.out.print(sb);
	}
}