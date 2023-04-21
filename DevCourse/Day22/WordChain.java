package DevCourse.Day22;

import java.util.*;

public class WordChain {

	public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();

        set.add(words[0]);
        String prev = words[0];
        for(int i = 1; i < words.length; i++) {
            String curr = words[i];
            
            if(isFailed(prev, curr) || set.contains(curr)) {
                answer[0] = (i % n) + 1; //사람 번호
                answer[1] = (i / n) + 1; //몇 번째 차례
                break;
            }
            
            prev = curr;
            set.add(prev);
        }
        
        return answer;
    }
    
    public static boolean isFailed(String prev, String curr) {
        int lastIndex = prev.length() - 1;
        
        return (prev.charAt(lastIndex) != curr.charAt(0));
    }

}
