package DevMatching.Day1;

public class Dungeon { //ÇÇ·Îµµ

	private static int answer = -1;
    
    private static int[] bucket;
    private static int[] items;
    private static int[] costs;
    private static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        int size = dungeons.length;
        bucket = new int[size];
        items = new int[size];
        costs = new int[size];
        visited = new boolean[size];
        
        for(int i = 0; i < size; i++){
            items[i] = dungeons[i][0];
            costs[i] = dungeons[i][1];
        }
        
        backTracking(k, size, 0);
        
        return answer;
    }
    
    public static void backTracking(int maxCost, int N, int depth) {
        if(depth == N) {
            int count = 0;
            
            for(int idx : bucket) {
                int costLimit = items[idx];
                int nextCost = costs[idx];
                if(maxCost >= costLimit) {
                    maxCost -= nextCost;
                    count += 1;
                }
            }
            answer = Math.max(count, answer);
            
            return;
        }
        
        for(int i = 0; i < items.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                
                bucket[depth] = i;
                backTracking(maxCost, N, depth + 1);
                
                visited[i] = false;
            }
        }

        return;
    }

}
