package DevCourse.Day11;

public class WordConverting {

	private static int answer = Integer.MAX_VALUE;
    
    private static boolean[] visited;
    private static String[] words;
    private static int[][] graph;
    
    public int solution(String begin, String target, String[] originalWords) {
        boolean isContained = false;
        
        //기저 사례 처리
        for(String s : originalWords) {
            if(s.equals(target)) {
                isContained = true;
                break;
            }
        }
        
        if(!isContained) {
            return 0;
        }
        
        //begin 추가
        int originalLength = originalWords.length;
        words = new String[originalLength + 1];
        words[0] = begin;
        
        for(int i = 1; i < originalLength + 1; i++){
            words[i] = originalWords[i - 1];
        }
        
        //그래프 생성
        int size = words.length;
        visited = new boolean[size];
        graph = new int[size][size];
        
        for(int i = 0; i < words.length - 1; i++) { //O(50*50*10)
            for(int j = i + 1; j < words.length; j++) {
                String wordA = words[i];
                String wordB = words[j];
            
                boolean result = checkTwoWords(wordA, wordB); //O(10)
                if(result == true){
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        
        DFS(0, 0, target);
        
        if(answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        
        return answer;
    }
    
    private static void DFS(int start, int depth, String target) {
        visited[start] = true;
        
        if(words[start].equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        for(int u = 0; u < graph.length; u++) {
            if(!visited[u] && (graph[start][u] == 1 || graph[u][start] == 1)) {
                DFS(u, depth + 1, target);
                visited[u] = false;
            }
        }
        
        return;
    }
    
    private static boolean checkTwoWords(String wordA, String wordB) {
        int posA = 0;
        int posB = 0;
        int count = wordA.length();
        while(posA < wordA.length() && posB < wordB.length()){
            if(wordA.charAt(posA) != wordB.charAt(posB)){
                count -= 1;
            }
            posA++;
            posB++;
        }
        
        if(count == wordA.length() - 1) {
            return true;
        }
        
        return false;
    }

}
