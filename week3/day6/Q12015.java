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
		int lengthOfLIS = 1; //���� 1¥�� ������ LIS ���̴� �׻� 1, ���빰�� arr[0] �ϳ�
		for(int i = 1; i < num; i++) {
			int target = arr[i];
			
			if(target > C[lengthOfLIS - 1]) { //���� ���Ұ� �����Ѵٸ�
				C[lengthOfLIS] = target; //�迭 �� �ڿ� �ٿ��ش�.
				lengthOfLIS++;
			}
			else { //���� ���Ұ� �������� �ʴ´ٸ� �̺�Ž�� => target�� ���� ����� ���� ��ü�Ѵ�.
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
