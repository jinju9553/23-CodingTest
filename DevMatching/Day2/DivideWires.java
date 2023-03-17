package DevMatching.Day2;

import java.util.*;

public class DivideWires { //전력망을 둘로 나누기
	
	private static boolean[] visited;
    private static int[][] graph;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        visited = new boolean[n + 1]; //0번 인덱스는 쓰지 않음
        graph = new int[n + 1][n + 1]; //0번 인덱스는 쓰지 않음
        
        for(int i = 0; i < wires.length; i++) {
            int v = wires[i][0];
            int w = wires[i][1];
            
            graph[v][w] = 1;
            graph[w][v] = 1;
        }
        
        for(int i = 0; i < wires.length; i++) {
            int v = wires[i][0];
            int w = wires[i][1];
            
            graph[v][w] = 0;
            graph[w][v] = 0;
            
            int a = BFS(v);
            int b = n - a;
            answer = Math.min(answer, Math.abs(a - b));
            
            graph[v][w] = 1;
            graph[w][v] = 1;
            
            visited = new boolean[n + 1];
        }
        
        return answer;
    }
    
    public static int BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
        visited[start] = true;
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int w = queue.poll();
            count += 1;
            
            for(int i = 1; i < graph.length; i++) {
                if(graph[w][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        
        return count;
    }

}
