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
			
			if(count >= N) { //UpperBound: �� ��� �߶�� �Ѵ�
				start = middle + 1;
				//������ �ߺ��̾ �ִ���̸� ��� ã�´�.
			}
			else if(count < N) { //LowerBound: �� ª�� �߶�� �Ѵ�
				end = middle;
			}
		}
		
		//middle + 1�� �ʰ��Ǵ� ������ ã�ƿ����� ��������� �ٽ� -1 ���ش�.
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
