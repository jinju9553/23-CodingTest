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
		while (remain > 0) { // 잔여 작업이 0개가 될 때까지
			// pq에 현재 시점까지 요청이 들어온 작업을 모두 추가한다
			while (jobIdx < size && jobs[jobIdx][0] <= currTime) {
				pq.add(jobs[jobIdx]);
				jobIdx++;
			}

			// pq가 비어있다면 다음 작업을 대기하기 위해 시점을 갱신한다.
			if (pq.isEmpty()) {
				currTime = jobs[jobIdx][0];
			} else { // pq 안에 작업이 있다면 시간을 계산해준다.
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
