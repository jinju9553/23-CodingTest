package second.week1.day6;

import java.io.*;
import java.util.*;

public class SWEA7465 {

	private static boolean[] visited;
	private static LinkedList<Integer>[] graph;

	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			String[] temp = br.readLine().split(" ");

			int N = Integer.parseInt(temp[0]); // 정점의 수
			int M = Integer.parseInt(temp[1]); // 간선의 수

			visited = new boolean[N + 1]; // 1부터 N까지
			graph = new LinkedList[N + 1]; // 1부터 N까지

			for (int i = 1; i <= N; i++) {
				graph[i] = new LinkedList<>();
			}

			for (int i = 0; i < M; i++) {
				String[] link = br.readLine().split(" ");

				int u = Integer.parseInt(link[0]);
				int v = Integer.parseInt(link[1]);

				graph[u].add(v);
				graph[v].add(u);
			}

			int answer = 0;
			for (int i = 1; i <= N; i++) { // 모든 정점에서 진입
				if (!visited[i]) {
					DFS(i);
					answer += 1;
				}
			}

			sb.append("#" + test_case + " ").append(answer).append("\n");
		}

		System.out.print(sb);
	}

	private static void DFS(int start) {
		visited[start] = true;

		for (int u : graph[start]) {
			if (!visited[u]) {
				DFS(u);
			}
		}

		return;
	}

}
