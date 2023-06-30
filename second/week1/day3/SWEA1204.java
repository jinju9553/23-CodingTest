package second.week1.day3;

import java.util.*;
import java.io.*;

public class SWEA1204 {

	private static int N = 1000;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			Map<Integer, Integer> map = new HashMap<>();

			String testCaseNum = br.readLine();
			String[] temp = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(temp[i]);

				Integer result = map.computeIfPresent(num, (k, v) -> v + 1);
				if (result == null) {
					map.put(num, 1);
				}
			}

			PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
					(o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())); // ��(value)�� ������������ ����

			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				pq.add(entry);
			}

			int maxFrequency = (pq.peek()).getValue();

			ArrayList<Integer> maxScores = new ArrayList<>();

			for (Map.Entry<Integer, Integer> entry : pq) {
				if (entry.getValue() == maxFrequency) {
					maxScores.add(entry.getKey());
				} else { // pq�� ������������ ���ĵǾ����Ƿ� maxFrequency�� ��Ÿ���� ������ ����
					break;
				}
			}

			maxScores.sort(Comparator.reverseOrder()); // �ֺ���� ������ ������������ ����

			int answer = maxScores.get(0); // ���� ū ������ �����´�.

			sb.append("#" + testCaseNum + " ").append(answer).append("\n");
		}

		System.out.print(sb);
	}
}
