package SWM.Day5;

import java.io.*;
import java.util.*;

public class N2149 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String key = br.readLine();
		char[] mixedKey = (key.toCharArray()).clone();
		Arrays.sort(mixedKey);
		
		String cryptogram = br.readLine();
		
		int keyLength = mixedKey.length;
		int cryptogramLength = cryptogram.length();
		
		List<Queue<Character>> list = new LinkedList<>();
		for(int i = 0; i < keyLength; i++) {
			Queue<Character> q = new LinkedList<>();
			list.add(q);
		}
		
		int n = 0;
		for(int i = 0; i < keyLength; i++) {
			int idx = key.indexOf(mixedKey[i]);
			
			Queue<Character> q = list.get(idx);
			
			if(!q.isEmpty()) {
				idx = key.indexOf(mixedKey[i], idx + 1);
				q = list.get(idx);
			}
			
			while(n < cryptogramLength) {
				q.add(cryptogram.charAt(n));
				n++;
				if((n % (cryptogramLength / keyLength)) == 0) {
					break;
				}
			}
			
			list.set(idx, q);
		}
		
		for(int i = 0; i < cryptogramLength; i++) {
			int idx = (i % keyLength);
			
			Queue<Character> q = list.get(idx);
			
			sb.append(q.poll());
		}
		
		System.out.println(sb);
	}

}
