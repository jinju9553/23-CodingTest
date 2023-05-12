package week7.day7;

import java.io.*;
import java.util.StringTokenizer;

public class Q11054 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[][] DP = new int[N][2];
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			DP[i][0] = 1; //�����ϴ� ���������� ����
			DP[i][1] = 0; //�����ϴ� ���������� ����
		}
		
		for(int i = 1; i < N; i++) {
			int target = arr[i];
			for(int j = 0; j < i; j++) {
				if(arr[j] < target) { //����
					DP[i][0] = Math.max(DP[j][0] + 1, DP[i][0]);
				}
				else if(arr[j] > target) { //����
					if(DP[j][0] > DP[j][1]) { //�����ϴٰ� �����ϴ� ����Ʈ���
						DP[i][1] = Math.max(DP[j][0] + 1, DP[i][1]);
					}
					else {
						DP[i][1] = Math.max(DP[j][1] + 1, DP[i][1]);
					}
				}
			}
		}
		
		int result = -1;
		for(int i = 0; i < N; i++) {
			int max = Math.max(DP[i][0], DP[i][1]);
			if(max > result) {
				result = max;
			}
		}
		
		System.out.print(result);
	}

}
