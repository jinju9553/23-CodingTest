package DevCourse.Day21;

import java.util.*;

public class H_Index {
	public int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);

		for (int n : citations) {
			int lowerBound = lowerBinarySearch(citations, n);
			int upperBound = citations.length - 1;
			int h = (upperBound - lowerBound) + 1;

			if (h >= n) {
				answer = Math.max(n, answer);
			} else {
				answer = Math.max(h, answer);
			}
		}

		return answer;
	}

	public static int lowerBinarySearch(int[] citations, int n) {
		int start = 0;
		int end = citations.length - 1;

		while (start < end) {
			int mid = (start + end) / 2;

			if (citations[mid] >= n) {
				end = mid;
			} else { // citations[mid] < n
				start = mid + 1;
			}
		}

		return start;
	}

}
