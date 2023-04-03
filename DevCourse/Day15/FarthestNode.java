package DevCourse.Day15;

import java.util.*;

public class FarthestNode {

	private static int[] count;
    private static boolean[] visited;
    private static boolean[][] graph;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        count = new int[n + 1];
        visited = new boolean[n + 1]; //0은 사용하지 않음
        graph = new boolean[n + 1][n + 1];
        
        for(int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
                
            graph[u][v] = true;
            graph[v][u] = true;;
        }
        
        answer = BFS(graph, 1, n);
        
        return answer;
    }
    
    private static int BFS(boolean[][] graph, int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        count[0] = 1;
        
        int width = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            while(size-- > 0) {
                int p = queue.poll();
                
                for(int v = 1; v < graph[0].length; v++) {
                    if(graph[p][v] && !visited[v]) {
                        count[width] += 1;
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
            width += 1;
        }

        return count[width - 2];
    }
}
