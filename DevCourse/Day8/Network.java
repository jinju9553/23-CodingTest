package DevCourse.Day8;

public class Network {

	private static boolean[] visited;
    
	public static void main(String[] args) {
    	
		
    	int n = 4;
    	int[][] computers = {{1, 1, 1, 0}, {1, 1, 0, 0}, {1, 0, 1, 0}, {0, 0, 0, 1}};
    	
		//int n = 3;
    	//int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		
        int answer = 0;
        
        int N = n;
        int numOfLink = N - 1;
        int edge = 0;
        
        for(int v = 0; v < N; v++) {
            for(int u = 0; u < N; u++) {
                if(v != u && computers[v][u] == 1) {
                    edge += 1;
                }
            }
        }
        
        edge /= 2;
        
        visited = new boolean[N];
        
        if(numOfLink == edge) { //이미 다 연결되어 있다면
        	answer = 1;
        }
        else {
            for(int v = 0; v < N; v++) { //모든 vertex에서 출발
            	if(!visited[v]) {
            		answer += 1;
            		DFS(computers, v);
            	}
            }
        }
        
        System.out.print(answer);
    }
    
    private static void DFS(int[][] computers, int start) {
        visited[start] = true;
        
        for(int v = 0; v < computers.length; v++) { //start에 인접한 모든 정점(여기선 전체 정점)
            if(v != start && !visited[v] && computers[start][v] == 1) {
                //start---v를 신장트리 간선이라고 표시?
                DFS(computers, v);
            }
        }
    }
}
