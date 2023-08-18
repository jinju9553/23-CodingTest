import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static ArrayList<Integer> graph[];
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] initLine = (br.readLine()).split(" ");
		int vertex = Integer.parseInt(initLine[0]);
		int edge = Integer.parseInt(initLine[1]);
		int start = Integer.parseInt(initLine[2]);
		
		visited = new boolean[vertex + 1]; 
		graph = new ArrayList[vertex + 1];
		
		for(int i = 1; i <= vertex; i++) {
			graph[i] = new ArrayList<>();
			visited[i] = false;
		}
		
		String[] initGraph; int v; int u;
		for(int i = 0; i < edge; i++) {
			initGraph = br.readLine().split(" ");
			u = Integer.parseInt(initGraph[0]);
			v = Integer.parseInt(initGraph[1]);
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		DFS(vertex, start);
		sb.append('\n');
		
		for(int i = 1; i <= vertex; i++)
			visited[i] = false;
		
		BFS(vertex, start);
		
		System.out.print(sb);
	}
	
	public static void DFS(int vertex, int currentStart) {
		visited[currentStart] = true;
		sb.append(currentStart).append(" ");
		for(int w = 1; w <= vertex; w++) { 
			if(graph[currentStart].contains(w) && !visited[w])
				DFS(vertex, w);
		}
	}
	
	public static void BFS(int vertex, int currentStart) {
		Queue<Integer> queue = new LinkedList<>();
		
		visited[currentStart] = true;
		queue.add(currentStart);
		sb.append(currentStart).append(" ");
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			for(int w = 1; w <= vertex; w++) {
				if(graph[v].contains(w) && !visited[w]) {
					visited[w] = true;
					queue.add(w);
					sb.append(w).append(" ");
				}
			}
		}
	}
}