package week7.day3;

import java.util.*;

public class Lifeboat {

	public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right) {
            if(people[left] + people[right] <= limit) { 
                left += 1;
            }
            right -= 1;
            answer += 1;
        }
        
        return answer;
    }

}
