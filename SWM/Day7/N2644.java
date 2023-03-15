package SWM.Day7;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class N2644 {

	private static boolean[] visited;
	private static LinkedList<Integer>[] graph;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		
		int target1 = Integer.parseInt(temp[0]);
		int target2 = Integer.parseInt(temp[1]);
		
		visited = new boolean[num + 1];
		graph = new LinkedList[num + 1];
		for(int i = 1; i <= num; i++) {
			visited[i] = false;
			graph[i] = new LinkedList<Integer>();
		}
		
		int numOfRelation = Integer.parseInt(br.readLine());
		for(int i = 0; i < numOfRelation; i++) {
			temp = br.readLine().split(" ");
			int p = Integer.parseInt(temp[0]);
			int q = Integer.parseInt(temp[1]);
			
			graph[p].add(q);
			graph[q].add(p);
		}
		
		int answer = 0;
		if(target1 != target2) {
			answer = BFS(target1, target2);
		}
		
		System.out.print(answer);
	}
	
	public static int BFS(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		int answer = -1;
		int height = 1;
		
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty() && answer == -1) {
			int size = queue.size();
			
			while(size-- > 0) {
				int w = queue.poll();
				
				for(int v : graph[w]) {
					if(!visited[v]) {
						if(v == end) {
							answer = height;
							break;
						}
						
						queue.add(v);
						visited[v] = true;
					}
				}				
			}
			height++;
		}
		
		return answer;
	}

}
