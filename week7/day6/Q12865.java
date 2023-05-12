package week7.day6;

import java.io.*;

public class Q12865 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = (br.readLine()).split(" ");
		
		int N = Integer.parseInt(temp[0]);
		int K = Integer.parseInt(temp[1]);
		
		int[] DP = new int[K + 1]; //0���� K����
		int[] weights = new int[N + 1]; //1���� N������
		int[] values = new int[N + 1]; //1���� N������
		
		for(int i = 1; i <= N; i++) {
			temp = (br.readLine()).split(" ");

			weights[i] = Integer.parseInt(temp[0]);
			values[i] = Integer.parseInt(temp[1]);
		}
		
		for(int i = 1; i <= N; i++) { //��ü N���� ������ Ž���Ѵ�.
			int w = weights[i];
			int v = values[i];
			for(int j = K; j >= w; j--) {
				//���� ������ ����(K)���� ���� Ž���ϴ� ������ ����(j)����
				//for�� ���ǿ������� i��° ������ ���濡 ���� �� �ִ��� Ȯ���Ѵ�.
				DP[j] = Math.max(DP[j - w] + v, DP[j]);
			}
		}
		
		System.out.print(DP[K]);
	}

}
