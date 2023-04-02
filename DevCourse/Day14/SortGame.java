package DevCourse.Day14;

import java.io.*;
import java.util.*;

public class SortGame {

	private static Map<int[], Integer> visited = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sorted = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sorted[i] = arr[i];
		}
		
		Arrays.sort(sorted);
		
		int answer = BFS(arr, sorted);
		
		System.out.print(answer);
	}
	
	public static int BFS(int[] arr, int[] target) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(arr);
		visited.put(arr, 1);
		
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- > 0) {
				int[] p = queue.poll();
				
				if(Arrays.equals(p, target)) {
					return count;
				}
				
				for(int i = 0; i < arr.length - 1; i++) {
					for(int j = i + 2; j < arr.length + 1; j++) {
						int[] reversedArray = reverseArray(p, i, j); //구간 [i, j)
						
						//시간 소모가 큰 부분
						if(!visited.containsKey(reversedArray)) {
							visited.put(reversedArray, 1);
							queue.add(reversedArray);
							
						}
					}
				}
			}
			count += 1;
		}
		
		return -1;
	}
	
	public static int[] reverseArray(int[] arr, int start, int end) {
		int[] reversedArray = new int[arr.length];
		
		for(int i = 0; i < start; i++) {
			reversedArray[i] = arr[i];
		}
		
		int idx = 0;
		for(int i = start; i < end; i++) {
			reversedArray[i] = arr[(end - idx) - 1];
			idx++;
		}
		
		for(int i = end; i < arr.length; i++) {
			reversedArray[i] = arr[i];
		}
		
		return reversedArray;
	}

}
