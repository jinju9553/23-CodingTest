package week5.day6;

import java.util.*;

public class Disguise {

	private static Map<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        int answer = 1;
                
        for(String[] c : clothes) {
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        for(int v : map.values()) {
            answer *= (v + 1);
        }
    
        return (answer - 1);
    }

}
