package SWM.Day7;

import java.io.*;
import java.util.Arrays;

public class N1920 {

	private static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int length = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		
		A = new int[length];
		for(int i = 0; i < length; i++) {
			A[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(A);
		
		int num = Integer.parseInt(br.readLine());
		temp = br.readLine().split(" ");
		
		int[] targets = new int[num];
		for(int i = 0; i < num; i++) {
			targets[i] = Integer.parseInt(temp[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < num; i++) {
			int result = BS(targets[i], 0, length - 1);
			sb.append(result).append('\n');
		}

		System.out.print(sb);
	}
	
	public static int BS(int key, int start, int end) {
		int middle = 0;
		
		if(start <= end) {
			middle = (start + end) / 2;
			
			if(key == A[middle]) {
				return 1;
			}
			else if(key < A[middle]) {
				return BS(key, start, middle - 1);
			}
			else if(key > A[middle]) {
				return BS(key, middle + 1, end);
			}
		}
		
		return 0;
	}

}
