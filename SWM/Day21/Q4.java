package SWM.Day21;

import java.io.*;
import java.util.*;

public class Q4 {
	
	public static final int N = 8;
	
	public static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		String input = "";
		for(int i = 0; i < temp.length; i++) {
			input += temp[i];
		}
		
		if(isPair(input)) {
			System.out.print(0);
		}
		else {
			int answer = BFS(input);
			System.out.print(answer);
		}
	} 
	
	public static int BFS(String start) {
		Queue<String> queue = new LinkedList<>();
		int width = 0;
		
		queue.add(start);
		map.putIfAbsent(start, 0);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- > 0) {
				String s = queue.poll();
				
				if(isPair(s)) {
					return width;
				}
				
				//젓가락을 swap하고 큐에 새로 넣는다.
				String nextStr = swapChar(s);
				
				if(!map.containsKey(nextStr)) {
					System.out.println(nextStr);
					queue.add(nextStr);
					map.put(nextStr, width);
				}
			}
			width += 1;
		}
		
		return -1;
	}
	
	public static String swapChar(String currentPair) {
		String result = "";
		
		char targetChar = findTargetChar(currentPair);
		
		int targetIdx = currentPair.lastIndexOf(targetChar);
		char swappedChar = currentPair.charAt(targetIdx - 2); 
		//문제: targetIdx가 무조건 2 이상일까?
		
		StringBuilder sb = new StringBuilder(currentPair);
		
		sb.setCharAt(targetIdx - 2, targetChar); //앞으로 보낸다 (2칸만?)
		sb.setCharAt(targetIdx, swappedChar);
		
		result = sb.toString();
		
		return result;
	}
	
	public static char findTargetChar(String currentPair) {
		char[] alphabets = {'A', 'B', 'C', 'D'};
		
		char targetChar = ' ';
		int max = -1;
		
		for(int i = 0; i < alphabets.length; i++) {
			int leftBound = currentPair.indexOf(alphabets[i]);
			int rightBound = currentPair.lastIndexOf(alphabets[i]);
			
			if(leftBound != -1 && rightBound != -1) {
				if(max < rightBound - leftBound) {
					max = rightBound - leftBound;
					targetChar = alphabets[i];
				}
			}
		}
	
		return targetChar;
	}
	
	public static boolean isPair(String currentPair) {
		for(int i = 0; i < N - 1; i += 2) {
			char a = currentPair.charAt(i);
			char b = currentPair.charAt(i + 1);
			
			if(a != b) {
				return false;
			}
		}
		
		return true;
	}

}
