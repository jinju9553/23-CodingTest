package second.week3.day1;

import java.io.*;

public class SWEA1213 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			String testCaseNum = br.readLine();
            
            String key = br.readLine();
            String sentence = br.readLine();
            
            int len = sentence.length() - sentence.replaceAll(key, "").length();
            
            int count = len / key.length();
            
            sb.append("#" + test_case + " ").append(count).append("\n");
		}
        
        System.out.println(sb);
	}

}
