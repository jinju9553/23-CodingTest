package SWM.Day10;

import java.io.*;
import java.util.StringTokenizer;

public class N1182 {

	private static int answer = 0;
	private static int target = 0;

	private static int[] items;
	private static int[] bucket;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		target = Integer.parseInt(temp[1]);

		items = new int[N];
		bucket = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			solution(i, 0, 0);
		}

		System.out.print(answer);
	}

	public static void solution(int N, int lastIndex, int k) {

		if (k == N) { // N: 이만큼 뽑으세요 & k: 지금까지 몇 개 뽑음
			int sum = 0;
			for (int n : bucket) {
				sum += n;
			}

			if (sum == target) {
				answer++;
			}
			
			return;
		}

		for (int i = lastIndex; i < items.length; i++) {
			bucket[k] = items[i];
			solution(N, i + 1, k + 1);
		}
	}
}
