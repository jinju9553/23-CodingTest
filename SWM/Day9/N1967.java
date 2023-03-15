package SWM.Day9;

import java.io.*;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class N1967 {
	
	static class Node{
		int vertex;  int weight;
		
		Node(int vertex, int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	private static LinkedList<Node>[] graph;
	private static boolean[] visited;
	private static int MAX_VERTEX = 0;
	private static int MAX_WEIGHT = 0;
	private static int ANSWER = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		graph = new LinkedList[num + 1]; //0¹øÀº ºñ¿öµÒ
		visited = new boolean[num + 1];
		
		for(int i = 1; i <= num; i++) {
			visited[i] = false;
			graph[i] = new LinkedList<Node>();
		}
		
		StringTokenizer st;
		for(int i = 0; i < num - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[parent].add(new Node(child, weight));
			graph[child].add(new Node(parent, weight));
		}

		DFS(1, 0);
		
		visited = new boolean[num + 1];
		
		DFS(MAX_VERTEX, 0);
		
		System.out.print(ANSWER);
	}
	
	public static void DFS(int start, int currDistance) {
		visited[start] = true;
		
		ANSWER = Math.max(currDistance, ANSWER);
		
		for(Node node : graph[start]) {
			int v = node.vertex;
			
			if(MAX_WEIGHT < node.weight) {
				MAX_WEIGHT = node.weight;
				MAX_VERTEX = node.vertex;
			}
			
			if(!visited[v]) {
				visited[v] = true;
				DFS(v, currDistance + node.weight);
			}
		}
	}

}
