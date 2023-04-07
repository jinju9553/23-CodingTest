package DevCourse.Day17;

import java.util.*;

public class Rank {

	private static int[] indegree;
    private static boolean[] visited; 
    private static boolean[][] graph;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        indegree = new int[n + 1];
        visited = new boolean[n + 1];
        graph = new boolean[n + 1][n + 1];
        
        for(int i = 0; i < results.length; i++) {
            int u = results[i][0];
            int v = results[i][1];
            
            graph[u][v] = true;
            indegree[v]++;
        }
        
        answer = topologicalSort();
        
        return answer;
    }
    
    public static int topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> prevNodes = new Stack<>();
        int answer = 0;
        
        for(int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                visited[i] = true;
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            int count = 0;
            while(size-- > 0) {
                int p = queue.poll();
                prevNodes.add(p);
                count += 1;
                
                System.out.print(p);

                for(int q = 1; q < graph.length; q++) {
                    if(graph[p][q]) {
                        indegree[q]--;
                    }

                    if(!visited[q] && indegree[q] == 0) {
                        visited[q] = true;
                        queue.add(q);
                    }
                }
            }
            System.out.print("|");
            
            //한 레벨 종료
            if(count == 1) {
                boolean isAllConnected = true;
                int q = prevNodes.pop();
                
                int nodesSize = prevNodes.size();
                while(nodesSize-- > 0) {
                    int p = prevNodes.peek();
                    if(graph[p][q]) {
                        prevNodes.pop();
                    }
                    else {
                        isAllConnected = false;
                    }
                }
                
                if(isAllConnected) {
                    answer += 1;
                }
            }

        }
        
        return answer;
    }

}
