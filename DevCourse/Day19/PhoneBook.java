package DevCourse.Day19;

import java.util.*;

public class PhoneBook {

	public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : phone_book) {
            map.put(s, 1);
        }
        
        for(String s : phone_book) {
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < s.length() - 1; i++) {
                sb.append(s.charAt(i));
                String subString = sb.toString();
                
                if(map.containsKey(subString)){
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }

}
