package week6.day4;

import java.util.*;

public class Delivery { //Node 클래스가 동일 패캐지 내에 정의되어 있음

	private static final int INF = Integer.MAX_VALUE;
    private static int[] dist;
    private static boolean[] visited;
    private static ArrayList<Node>[] graph;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int start = 1;
        
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        graph = new ArrayList[N + 1]; 
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < road.length; i++) {
            int v = road[i][0];
            int u = road[i][1];
            int weight = road[i][2];
            
            graph[v].add(new Node(u, weight));
            graph[u].add(new Node(v, weight));
        }
        
        dijkstra(1);
        
        //K 이하인 것들을 고른다.
        for(int d : dist) {
            if(d <= K){
                answer += 1;
            }
        }

        return answer;
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o1.weight, o2.weight));
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            int v = pq.poll().index;
            
            if(visited[v]) {
                continue;
            }
            
            visited[v] = true;
            
            for(Node next : graph[v]) {
                if(dist[next.index] > dist[v] + next.weight) {
                    dist[next.index] = dist[v] + next.weight;
                    
                    int nextWeight = dist[next.index];
                    pq.add(new Node(next.index, nextWeight));
                }
            }
        }
        
        return;
    }

}