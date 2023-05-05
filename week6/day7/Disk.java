package week6.day7;

import java.util.*;

public class Disk {

	public int solution(int[][] jobs) {
		int answer = 0;

		Arrays.sort(jobs, (o1, o2) -> Integer.compare(o1[0], o2[0]));

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

		int sum = 0;
		int jobIdx = 0;
		int currTime = 0;

		int size = jobs.length;
		int remain = size;
		while (remain > 0) { // �ܿ� �۾��� 0���� �� ������
			// pq�� ���� �������� ��û�� ���� �۾��� ��� �߰��Ѵ�
			while (jobIdx < size && jobs[jobIdx][0] <= currTime) {
				pq.add(jobs[jobIdx]);
				jobIdx++;
			}

			// pq�� ����ִٸ� ���� �۾��� ����ϱ� ���� ������ �����Ѵ�.
			if (pq.isEmpty()) {
				currTime = jobs[jobIdx][0];
			} else { // pq �ȿ� �۾��� �ִٸ� �ð��� ������ش�.
				int[] job = pq.poll();

				currTime += job[1];
				sum += (currTime - job[0]);

				remain--;
			}
		}

		answer = (int) (sum / size);

		if (answer < 0) {
			return 0;
		}

		return answer;
	}
}
