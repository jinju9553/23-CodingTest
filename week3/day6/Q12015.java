package week3.day6;

import java.io.*;

public class Q12015 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		int[] C = new int[num];
		
		String[] splited = br.readLine().split(" ");
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(splited[i]);
		}
		
		C[0] = arr[0];
		int lengthOfLIS = 1; //길이 1짜리 수열의 LIS 길이는 항상 1, 내용물은 arr[0] 하나
		for(int i = 1; i < num; i++) {
			int target = arr[i];
			
			if(target > C[lengthOfLIS - 1]) { //다음 원소가 증가한다면
				C[lengthOfLIS] = target; //배열 맨 뒤에 붙여준다.
				lengthOfLIS++;
			}
			else { //다음 원소가 증가하지 않는다면 이분탐색 => target과 가장 가까운 값과 교체한다.
				int start = 0;
				int end = lengthOfLIS;
				
				while(start < end) {
					int mid = (start + end) / 2;
					
					if(C[mid] < target) {
						start = mid + 1;
					}
					else { //C[mid] >= target
						end = mid;
					}
					
				}
				C[start] = target;
			}	
		}
		
		System.out.print(lengthOfLIS);
	}

}
