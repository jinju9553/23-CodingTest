package week6.day4;

import java.util.*;
import java.io.*;

public class Dijkstra {

	private static final int INF = Integer.MAX_VALUE;
	private static int[] dist;
	private static boolean[] visited;
	private static ArrayList<Node>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력 받기
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[v + 1];
		for(int i = 0; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(w, weight));
		}
		
		int start = Integer.parseInt(br.readLine());
		
		//배열 초기화
		
		dist = new int[v + 1]; //0은 사용하지 않음
		visited = new boolean[v + 1];

		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		//탐색 시작
		dijkstra(start);
		
		//결과 출력
		for(int d : dist) {
			if(d == INF) {
				System.out.print(0 + " ");
			}
			else {
				System.out.print(d + " ");
			}
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>(
				(o1, o2) -> Integer.compare(o1.weight, o2.weight));
		pq.add(new Node(start, 0)); //BFS처럼 첫 정점을 넣고 시작
		
		while(!pq.isEmpty()) {
			int v = pq.poll().index;
			
			if(visited[v]) { //이미 방문한 정점이면 패스
				continue;
			}
			
			visited[v] = true; //방문처리
			
			for(Node next : graph[v]) { //v와 연결된 모든 next에 대해
				if(dist[next.index] > dist[v] + next.weight) { //더 짧은 경로를 발견했다면
					dist[next.index] = dist[v] + next.weight; //해당 경로로 갱신시킨다.
					
					int nextWeight = dist[next.index];
					pq.add(new Node(next.index, nextWeight)); //큐에 넣고 계속 탐색
				}
			}
		}
		
		return;
	}
}

class Node {
	int index;
	int weight;
	
	public Node(int index, int weight) {
		this.index = index;
		this.weight = weight;
	}
}
