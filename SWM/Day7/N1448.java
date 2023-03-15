package SWM.Day7;

import java.io.*;
import java.util.Arrays;

public class N1448 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		
		for(int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int max = -1;
		for(int i = size - 1; i >= 2; i--) {
			int a = arr[i - 1];
			int b = arr[i - 2];
			int c = arr[i];
			if(c < a + b) {
				max = Math.max(a + b + c, max);
			}
		}
		
		System.out.print(max);
		
	}

}
