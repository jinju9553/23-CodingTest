package second.week2.day2;

import java.util.*;
import java.io.*;

public class SWEA1225 {
    private static final int N = 8;
    private static final int COUNT = 5;
    
	public static void main(String args[]) throws IOException { //Deque »ç¿ë
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int T = 10; //Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			String testCaseNum = br.readLine();
            Deque<Integer> deque = new LinkedList<>();
            
            String[] temp = br.readLine().split(" ");
            for(int i = 0; i < N; i++) {
                int n = Integer.parseInt(temp[i]);
                deque.add(n);
            }
            
            int k = 1;
            int curr = -1;
            while(curr != 0) {
                curr = deque.poll();
                curr -= k;
                k += 1;

                if(curr < 0) {
                    curr = 0;
                }
                
                if(k > COUNT) {
                	k = 1;
                }
                
                deque.add(curr);
            }
            
            sb.append("#" + test_case + " ");
            for(int n : deque) {
                sb.append(n + " ");
            }
            sb.append("\n");
		}
        
        System.out.print(sb);
	}
}
