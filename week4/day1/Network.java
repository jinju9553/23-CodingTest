package week4.day1;

public class Network {

	private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        for(int v = 0; v < n; v++) { //모든 vertex에서 출발
            if(!visited[v]) {
            	answer++;
                DFS(computers, v);
            }
        }
        
        return answer;
    }
    
    private static void DFS(int[][] computers, int start) {
        visited[start] = true;
        
        for(int v = 0; v < computers.length; v++) {
            if(v != start && !visited[v] && computers[start][v] == 1) {
                DFS(computers, v);
            }
        }
        
        return;
    }
}
