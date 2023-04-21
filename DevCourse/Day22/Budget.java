package DevCourse.Day22;

import java.util.Arrays;

public class Budget {

	public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        for(int num : d) {
            if(budget >= num){
                budget -= num;
                answer++;
            }
        }
        
        return answer;
    }

}
