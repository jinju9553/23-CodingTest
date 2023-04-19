package DevCourse.Day20;

import java.util.*;

public class Marathon {

	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String p : participant) {
            if(map.containsKey(p)) {
                map.compute(p, (k, v) -> v + 1);
            }
            else {
                map.put(p, 1);
            }
        }
        
        for(String c : completion) {
            map.computeIfPresent(c, (k, v) -> v - 1);
        }
        
        for(String key : map.keySet()) {
            if(map.get(key) > 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }

}
