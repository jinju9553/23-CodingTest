package DevMatching.Day2;

public class Dictionary { //모음사전

	public static int count = 0;
    public static int answer = 0;
    public static StringBuilder bucket = new StringBuilder();
    public static String[] items = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) { //중복순열
        
        int length = items.length;
        
        DFS(word, length, 0);
        
        return answer;
    }
    
    public static void DFS(String targetWord, int N, int depth) {
        
        String result = bucket.toString();
        if(result.equals(targetWord)) {
            answer = count;
            return;
        }
        
        if(N == depth) {
            return;
        }
        
        for(int i = 0; i < items.length; i++) {
            count += 1;
            bucket.append(items[i]);
            DFS(targetWord, N, depth + 1);
            bucket.deleteCharAt(depth);
        }
        
        return;
    }
}
