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
		
		//�Է� �ޱ�
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
		
		//�迭 �ʱ�ȭ
		
		dist = new int[v + 1]; //0�� ������� ����
		visited = new boolean[v + 1];

		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		//Ž�� ����
		dijkstra(start);
		
		//��� ���
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
		pq.add(new Node(start, 0)); //BFSó�� ù ������ �ְ� ����
		
		while(!pq.isEmpty()) {
			int v = pq.poll().index;
			
			if(visited[v]) { //�̹� �湮�� �����̸� �н�
				continue;
			}
			
			visited[v] = true; //�湮ó��
			
			for(Node next : graph[v]) { //v�� ����� ��� next�� ����
				if(dist[next.index] > dist[v] + next.weight) { //�� ª�� ��θ� �߰��ߴٸ�
					dist[next.index] = dist[v] + next.weight; //�ش� ��η� ���Ž�Ų��.
					
					int nextWeight = dist[next.index];
					pq.add(new Node(next.index, nextWeight)); //ť�� �ְ� ��� Ž��
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
