package week2.day5;

import java.io.*;

public class N1654 {

	private static long[] cables;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int K = Integer.parseInt(temp[0]);
		int N = Integer.parseInt(temp[1]);
		
		cables = new long[K];
		
		long maxLength = -1;
		for(int i = 0; i < K; i++) {
			cables[i] = Long.parseLong(br.readLine());
			if(cables[i] > maxLength) {
				maxLength = cables[i];
			}
		}
		
		long answer = binarySearch(N, 0, maxLength + 1); 
		
		System.out.print(answer);
	}
	
	public static long binarySearch(int N, long start, long end) {
		long middle = 0;
		
		while(start < end) {
			middle = (start + end) / 2;
			
			long count = cutCables(middle);
			
			if(count >= N) { //UpperBound: 더 길게 잘라야 한다
				start = middle + 1;
				//개수가 중복이어도 최대길이를 계속 찾는다.
			}
			else if(count < N) { //LowerBound: 더 짧게 잘라야 한다
				end = middle;
			}
		}
		
		//middle + 1로 초과되는 범위를 찾아왔으니 결과값에는 다시 -1 해준다.
		return middle - 1;
	}
	
	public static long cutCables(long length) {
		long count = 0;
	
		for(int i = 0; i < cables.length; i++) {
			count += (cables[i] / length);
		}
		
		return count;
	}

}
